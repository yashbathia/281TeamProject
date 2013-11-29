package com.laptop.cart;

import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<LineItems> lineItemList;

	
	public ShoppingCart()
	{
		lineItemList = new ArrayList<LineItems>();
	}

	public ArrayList<LineItems> getLineItemList() {
		return lineItemList;
	}

	public void setLineItemList(ArrayList<LineItems> lineItemList) {
		this.lineItemList = lineItemList;
	}

	public void addItem(LineItems newLineItem, int maxQty)
	{
		
		 int id = newLineItem.getItem().getId();
	       for (int i = 0; i < lineItemList.size(); i++)
	        {
	            LineItems lineItem = lineItemList.get(i);
	            if (lineItem.getItem().getId() == id)
	            {
	            	int currentQty = lineItem.getQuantity();
	            	if(maxQty>= currentQty+1)
	            	{
	            	lineItem.setQuantity(currentQty+1);
	                }
	            	return;
	            }
	        }
	        lineItemList.add(newLineItem);
	}
	
	public void removeItem(LineItems lineItem)
    {
		int id = lineItem.getItem().getId();
        for (int i = 0; i < lineItemList.size(); i++)
        {
            LineItems lItem = lineItemList.get(i);
            if (lItem.getItem().getId() == id)
            {
            	lineItemList.remove(i);
                return;
            }
        }
    }
	
}
