package api.pmntlgy.project101.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "table1")
public class Model1 {

	@Column(name = "ProfileName")
	String profileName;

	@Column(name = "TransactionDate")
	Date transactionDate;

	@Column(name = "TransactionAmount")
	double transactionAmount;

	@Column(name = "TransactionNarrative")
	String transactionNarrative;

	@Column(name = "TransactionDescription")
	String transactionDescription;

	@Column(name = "TransactionID")
	String transactionID;

	@Column(name = "TransactionType")
	char transactionType;

	@Column(name = "WalletReference")
	String walletReference;
	

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")

	long Id;

	public Model1() {
		super();
	}

	public Model1(String profileName, Date transactionDate, double transactionAmount, String transactionNarrative,
			String transactionDescription, String transactionID, char transactionType, String walletReference) {
		super();
		this.profileName = profileName;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionNarrative = transactionNarrative;
		this.transactionDescription = transactionDescription;
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.walletReference = walletReference;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public char getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}

	public String getWallentReference() {
		return walletReference;
	}

	public void setWallentReference(String walletReference) {
		walletReference = walletReference;
	}

	@Override
	public String toString() {
		return "Model1 [profileName=" + profileName + ", transactionDate=" + transactionDate + ", transactionAmount="
				+ transactionAmount + ", transactionNarrative=" + transactionNarrative + ", transactionDescription="
				+ transactionDescription + ", transactionID=" + transactionID + ", transactionType=" + transactionType
				+ ", walletReference=" + walletReference + ", Id=" + Id + "]";
	}

}
