package com.example.islami;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RadioChannelResponse{

	@SerializedName("radios")
	private List<RadiosItem> radios;

	public void setRadios(List<RadiosItem> radios){
		this.radios = radios;
	}

	public List<RadiosItem> getRadios(){
		return radios;
	}

	@Override
 	public String toString(){
		return 
			"RadioChannelResponse{" + 
			"radios = '" + radios + '\'' + 
			"}";
		}
}