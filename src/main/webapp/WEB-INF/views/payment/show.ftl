<#import "../layout/layout.ftl" as layout>
<@layout.body>
	<h1>Payment</h1>
	
	<table class="table table-striped">		
		<tr>
			<td>First name</td>
			<td>${payment.firstName!}</td>
		</tr>
		<tr>
			<td>Last name</td>
			<td>${payment.lastName!}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${payment.email!}</td>
		</tr>
		<tr>
			<td>Amount</td>
			<td>${payment.amount!}</td>
		</tr>
	</table>
</@layout.body>