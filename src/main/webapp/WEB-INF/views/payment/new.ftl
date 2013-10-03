<#import "../layout/layout.ftl" as layout>
<@layout.body>
	<h1>Create payment</h1>
	
    <form id="paymentForm" class="form-horizontal" action="save" method="post">
    	<div class="control-group">
		    <label class="control-label" for="firstName">First name</label>
		    <div class="controls">
		    <input type="text" name="firstName" id="firstName" placeholder="First name" maxlength="50" required>
		    </div>
	    </div>
	    <div class="control-group">
		    <label class="control-label" for="lastName">Last name</label>
		    <div class="controls">
		    <input type="text" name="lastName" id="lastName" placeholder="Last name" maxlength="50" required>
		    </div>
	    </div>
	    <div class="control-group">
		    <label class="control-label" for="inputEmail">Email</label>
		    <div class="controls">
		    	<input type="email" name="email" id="inputEmail" placeholder="Email" required>
	    	</div>
	    </div>
	    <div class="control-group">
		    <label class="control-label" for="amount">Amount</label>
		    <div class="controls">
		    	<input type="text" name="amount" id="amount" placeholder="Amount" number="true" min="0" max="10000000000" required>
	    	</div>
	    </div>
		
	    <div class="control-group">
		    <div class="controls">
			    </label>
			    <button type="submit" class="btn">Pay</button> 
		    </div>
	    </div>
    </form>
    <script>
		$("#paymentForm").validate();
	</script>
</@layout.body>