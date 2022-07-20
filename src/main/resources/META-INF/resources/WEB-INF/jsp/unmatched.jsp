<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table>
		<thead>
			<tr>
				<th>File 1</th>
				<th>File 2</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>TransactionDate</th>
								<th>TransactionAmount</th>
								<th>TransactionID</th>
								<th>TransactionType</th>
								


							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unmatched1}" var="Model1">
								<tr>

									<td>${Model1.transactionDate}</td>
									<td>${Model1.transactionAmount}</td>
									<td>${Model1.transactionID}</td>
									<td>${Model1.transactionType}</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
				<td>|${message}|
				<td>
				<td>


					<table class="table table-striped">
						<thead>
							<tr>

								<th>TransactionDate</th>
								<th>TransactionAmount</th>
								<th>TransactionID</th>
								<th>TransactionType</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unmatched2}" var="Model2">
								<tr>

									<td>${Model2.transactionDate}</td>
									<td>${Model2.transactionAmount}</td>
									<td>${Model2.transactionID}</td>
									<td>${Model2.transactionType}</td>
								
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</td>
			</tr>
	</table>
	<div>
		<form method="get">
			<button onClick=""
				class="bg-blue-400 text-white px-2 py-3 w-full text-left rounded-t-md">
				Download</button>

		</form>
	</div>

</div>
<%@ include file="common/footer.jspf"%>