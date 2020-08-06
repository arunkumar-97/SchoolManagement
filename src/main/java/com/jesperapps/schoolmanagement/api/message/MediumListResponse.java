package com.jesperapps.schoolmanagement.api.message;

import java.util.ArrayList;
import java.util.List;

public class MediumListResponse extends BaseResponse{
	
	public MediumListResponse() {
		
	}
	public MediumListResponse(int statuscode,String description) {
		super();
		mediums=new ArrayList<MediumResponse>();
		
	}
	
		private List<MediumResponse> mediums;

		public List<MediumResponse> getMediums() {
			return mediums;
		}
		public void setMediums(List<MediumResponse> mediums) {
			this.mediums = mediums;
		}
		public void addclss(MediumResponse mediumListResponse) {
			this.mediums.add(mediumListResponse);
			
		}

}
