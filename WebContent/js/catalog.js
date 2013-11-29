/**
 * 
 */
$(document).ready(function() {
	     
	           $.get('ProductController',{ tenantId:1},function(responseJson) {
	            if(responseJson!=null){
	               $("#dataTable").find("tr:gt(0)").remove();
	                var table1 = $("#dataTable");
	                $.each(responseJson, function(key,value) {
	                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                        rowNew.children().eq(0).text(value['brand']);
	                        rowNew.children().eq(1).text(value['model']);
	                        rowNew.children().eq(2).text(value['specification']);
	                        rowNew.children().eq(3).text(value['price']);
	                        rowNew.children().eq(4).text(value['qty']);
	                        rowNew.children().eq(5).html('<button type = "submit" name = "submit" class = "btn btn-primary " onclick="addToCart('+value['id']+')"  id ='+value['id']+'><i class="icon-plus-sign icon-white"></i> Add to Cart</Button>');
	                        rowNew.appendTo(table1);
	                });
	                }
	            });
	                  
	       
	});



function addToCart(id){
	   

	var URL = 'CartController';
	
	$.post(URL,{productId:id,action:'add'}, function(data) {
		var result = data.split(":");
		if(result[0]=='success')
		{
			window.location.href = "shopping-cart.jsp";
			// forward the request to landing page and remove the below code.
			//$reply = $("#loginMsgSuccess").append(result[1]).fadeIn(1000);
			//$form.prepend($reply)[0].reset();
		
		}else
		{
			$reply = $("#errorMsg").append(result[1]).fadeIn(1000);
			//$form.prepend($reply)[0].reset();
		}
		
			
	});
	
 
}

//$(".btn.btn-primary").click(function() {
//    alert(this.id);
//});

