<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Comparison Results</caption>
		<thead>
			<tr>
				<th>File 1</th>
				<th>File 2</th>
				<th></th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<td><label>Name: ${filename1} <br />Total Records:
						${record1} <br />Matching Records:: ${matched1} <br /> Unmatched
						Records : ${unmatched1}<br /> Duplicate Records: ${duplicate1}
				</label></td>

				<td><label>Name: ${filename2} <br />Total Records:
						${record2} <br />Matching Records: ${matched2} <br /> Unmatched
						Records: ${unmatched2} <br /> Duplicate Records: ${duplicate2}
				</label></td>



			</tr>

			<tr>
				<td><br />
					<form method="post" action="comp1">
						<button onClick=""
							class="bg-blue-400 text-white px-2 py-3 w-full text-left rounded-t-md">
							Duplicates List</button>
					</form></td>


				<td><br />
					<form method="post" action="comp">
						<button onClick=""
							class="bg-blue-400 text-white px-2 py-3 w-full text-left rounded-t-md">
							Unmatched Report</button>
					</form></td>

			</tr>


		</tbody>
	</table>
	<div></div>

</div>
<%@ include file="common/footer.jspf"%>