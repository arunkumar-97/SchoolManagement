package com.jesperapps.schoolmanagement.api.message;

public class ResponseClass {

		public int statuscode;
		public String description;
		
		public ResponseClass() 
		{
			
		}
		
		public ResponseClass(int statuscode, String description) 
		{
			super();
			this.statuscode = statuscode;
			this.description = description;
		}
		
		public int getStatuscode() 
		{
			return statuscode;
		}
		public void setStatuscode(int statuscode) 
		{
			this.statuscode = statuscode;
		}
		public String getDescription()
		{
			return description;
		}
		public void setDescription(String description) 
		{
			this.description = description;
		}
		
}
