<#import "../layout/layout.ftl" as layout>
<@layout.body>
	<h1>Payment list</h1>
	<table class="table table-condensed">
		<thead>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Amount</th>
		</thead>
		<tbody>
			<#list payments as payment>
				<tr onclick="document.location = 'show/${payment.id}';">
					<td>${payment.firstName!}</td>
					<td>${payment.lastName!}</td>
					<td>${payment.email!}</td>
					<td>${payment.amount!}</td>
				</tr>
			</#list>
		</tbody>
	</table>
</@layout.body>