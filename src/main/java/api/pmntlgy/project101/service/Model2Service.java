package api.pmntlgy.project101.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api.pmntlgy.project101.model.Model1;
import api.pmntlgy.project101.model.Model2;

@Transactional
public interface Model2Service extends PagingAndSortingRepository<Model2, Long> {

	public Iterable<Model2> findByTransactionIDAndWalletReference(String transacationID, String walletReference);

	@Modifying
	@Query(value = "LOAD DATA LOCAL INFILE :path " + "INTO TABLE table2 " + "FIELDS TERMINATED BY ',' "
			+ "IGNORE 1 ROWS "
			+ "(ProfileName,TransactionDate,TransactionAmount,TransactionNarrative,TransactionDescription,TransactionID,TransactionType,WalletReference)\r\n", nativeQuery = true)
	public void loadFile(@Param("path") String path);

	@Query(value = "SELECT * \r\n" + "FROM table2 \r\n" + "WHERE transactionId in (\r\n"
			+ "SELECT distinct t2.TransactionId \r\n" + "FROM table1 t1, table2 t2 \r\n"
			+ "WHERE t1.TransactionId = t2.TransactionId and \r\n"
			+ "t1.TransactionDate = t2.TransactionDate and t1.WalletReference = t2.WalletReference \r\n"
			+ "and t1.transactionAmount=t2.transactionAmount and t1.transactionType= t2.transactionType)", nativeQuery = true)
	public List<Model2> getMatchedTransactions();

	@Query(value = "SELECT count(distinct TransactionId) \r\n" + "FROM table2 \r\n" + "WHERE transactionId in (\r\n"
			+ "SELECT distinct t2.TransactionId \r\n" + "FROM table1 t1, table2 t2 \r\n"
			+ "WHERE t1.TransactionId = t2.TransactionId and \r\n"
			+ "t1.TransactionDate = t2.TransactionDate and t1.WalletReference = t2.WalletReference \r\n"
			+ "and t1.transactionAmount=t2.transactionAmount and t1.transactionType= t2.transactionType)", nativeQuery = true)
	public int getMatched();

	@Query(value = "SELECT * \r\n" + "FROM table2 \r\n" + "WHERE transactionId not in (\r\n"
			+ "SELECT distinct t2.TransactionId \r\n" + "FROM table1 t1, table2 t2 \r\n"
			+ "WHERE t1.TransactionId = t2.TransactionId and \r\n"
			+ "t1.TransactionDate = t2.TransactionDate and t1.WalletReference = t2.WalletReference \r\n"
			+ "and t1.transactionAmount=t2.transactionAmount and t1.transactionType= t2.transactionType)", nativeQuery = true)
	public List<Model2> getUnMatchedTransactions();

	@Query(value = "SELECT count(distinct TransactionId)   \r\n" + "FROM table2 \r\n"
			+ "WHERE transactionId not in (\r\n" + "SELECT distinct t2.TransactionId \r\n"
			+ "FROM table1 t1, table2 t2 \r\n" + "WHERE t1.TransactionId = t2.TransactionId and \r\n"
			+ "t1.TransactionDate = t2.TransactionDate and t1.WalletReference = t2.WalletReference \r\n"
			+ "and t1.transactionAmount=t2.transactionAmount and t1.transactionType= t2.transactionType)", nativeQuery = true)
	public int getUnMatched();

	@Query(value = "SELECT * FROM table1 WHERE TransactionId in \r\n" + "(SELECT TransactionId FROM \r\n" + "( \r\n"
			+ "SELECT TransactionId, count(TransactionId) appearance \r\n" + "FROM table1 \r\n"
			+ "GROUP BY TransactionId \r\n" + "HAVING appearance>1) as sb1 )", nativeQuery = true)
	public List<Model2> getDuplicateRecords();

	@Query(value = "SELECT count(distinct TransactionId) FROM table2 WHERE TransactionId in \r\n"
			+ "(SELECT TransactionId FROM \r\n" + "( \r\n"
			+ "SELECT TransactionId, count(TransactionId) appearance \r\n" + "FROM table1 \r\n"
			+ "GROUP BY TransactionId \r\n" + "HAVING appearance>1) as sb1 )", nativeQuery = true)
	public int getDuplicate();

}
