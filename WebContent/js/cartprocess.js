/**
 * 
 */
$(document).ready(function() {
	     
	           $.get('CartController',function(responseJson) {
	            if(responseJson!=null){
	               $("#dataTable").find("tr:gt(0)").remove();
	                var table1 = $("#dataTable");
	                var totalCost = 0;
	                $.each(responseJson, function(key,value) {
	                	var item = value['item'];
	                	var qty = value ['quantity'];
	                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                        rowNew.children().eq(0).text(item['brand']);
	                        rowNew.children().eq(1).text(item['model']);
	                        rowNew.children().eq(2).text(item['specification']);
	                        rowNew.children().eq(3).text(item['price']);
	                        rowNew.children().eq(4).text(qty);
	                        rowNew.children().eq(5).html('<button type = "submit" name = "submit" class = "btn btn-primary " onclick="deleteFromCart('+item['id']+')"  id ='+item['id']+'><i class="icon-trash icon-white"></i> Delete</Button>');
	                        rowNew.appendTo(table1);
	                        totalCost = totalCost + (item['price']*qty);
	                       
	                });
	                var rowNew = $("<tr><td colspan = '6'></td></tr>");
	                rowNew.children().eq(0).html('<p ><h4 class = "alert alert-info">Total price of your cart : '+totalCost+'</h4> </p>');
	                rowNew.appendTo(table1).fadeIn(1000);
	               // rowNew.children().eq(1).html('<button type = "submit" name = "submit" class = "btn btn-primary">Check out Cart</button>');
	                var rowNew = $("<tr><td colspan = '6'></td></tr>");
	                rowNew.children().eq(0).html('<button type = "submit" name = "submit" class = "btn btn-success"><i class="icon-shopping-cart"></i> Check out Cart</button>');
	                rowNew.appendTo(table1).fadeIn(1000);
	               // $("#totalMsg").append('<p class = "alert alert-success">Total price of your cart : '+totalCost+' </p> </br> <button type = "submit" name = "submit" class = "btn btn-primary pull-right">Check out</button> ').fadeIn(1000);
	                }
	            });
	                  
	       
	});


function deleteFromCart(id){
	   
	
	var URL = 'CartController';
	
	$.post(URL,{productId:id,action:'delete'}, function(data) {
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