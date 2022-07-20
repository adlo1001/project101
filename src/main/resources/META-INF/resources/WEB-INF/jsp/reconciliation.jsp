<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container ">
	<table class="table table-striped">
		<caption>Specify Files to Compare</caption>
		<thead>
			<tr>
				<th></th>
				<th></th>
				<th></th>

			</tr>
		</thead>

		<tbody>
			<form:form method="post"  enctype="multipart/form-data">
				<tr>

					<td><label>Select File 1</label></td>
					<td><input type="file" id="myFile1" required="required"
						name="filename1"></td>
				</tr>
				<tr>
					<td><label>Select File 2</label></td>
					<td><input type="file" id="myFile2" required="required"
						name="filename2"></td>

				</tr>
				<tr>
					<td><br /></td>
					<td><br />
					
						<button onClick=""
							class="bg-blue-400 text-white px-2 py-3 w-full text-left rounded-t-md">
							Compare</button></td>


				</tr>
			</form:form>
		</tbody>

	</table>
	<div></div>

</div>
<%@ include file="common/footer.jspf"%>