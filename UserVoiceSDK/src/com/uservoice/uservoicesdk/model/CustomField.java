package com.uservoice.uservoicesdk.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomField extends BaseModel {
	private String name;
	private List<String> predefinedValues;
	
	@Override
	public void load(JSONObject object) throws JSONException {
		super.load(object);
		name = getString(object, "name");
		predefinedValues = new ArrayList<String>();
		JSONArray values = object.getJSONArray("possible_values");
		for (int i = 0; i < values.length(); i++) {
			JSONObject value = values.getJSONObject(i);
			predefinedValues.add(getString(value, "value"));
		}
	}
	
	public boolean isPredefined() {
		return predefinedValues.size() > 0;
	}
	
	public List<String> getPredefinedValues() {
		return predefinedValues;
	}
	
	public String getName() {
		return name;
	}
}
