<#import "../layout/layout.ftl" as layout>
<@layout.body>
	<h1>NSA payment list</h1>
	<table id="nsa-table" class="table table-condensed">
		<thead>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Amount</th>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
		$(document).ready(function(){
			function reloadTable() {
				$.getJSON("/demo/nsa/payments",function(result){
					$('#nsa-table tbody').html('');
				    $.each(result, function(i, elem){
				    	$('#nsa-table tbody').append('<tr><td>'+elem.firstName+'</td><td>'+elem.lastName+'</td><td>'+elem.email+'</td><td>'+elem.amount+'</td></tr>')
				    });
				});
			}			
  			setInterval(reloadTable, 1000);
		});
	</script>
</@layout.body>