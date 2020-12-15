package service;

import entity.HttoBodyBeanInfoSpecifique;
import entity.HttpBodyBeanApplication;
import entity.HttpBodyBeanDocAchemine;
import entity.HttpBodyBeanExtrasPourApp;
import entity.HttpBodyBeanInfoGeneral;
import entity.HttpBodyBeanSuivieApplication;
import entity.HttpBodyBeanSuivieTelephonique;
import entity.HttpBodyBeanUser;
import entity.HttpBodySuiviEnPersonne;
import entity.InfoApplication;
import entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serializer {
	static public String serialize(Object o) {
		//return new Gson().toJson(o);
		Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
		return gson.toJson(o);
	}

	/*
	 * static public T deserialize(String json, Class<T> t) { return new
	 * Gson().fromJson(json, t); }
	 */

	static public User deserializeUser(String json) {
		return new Gson().fromJson(json, User.class);
	}

	static public HttpBodyBeanUser deserializeHttpBodyBeanUser(String json) {
		return new Gson().fromJson(json, HttpBodyBeanUser.class);
	}

	static public HttpBodyBeanInfoGeneral deserializeHttpBodyBeanInfoGeneral(String json) {
		return new Gson().fromJson(json, HttpBodyBeanInfoGeneral.class);
	}

	static public HttpBodyBeanSuivieApplication deserializeHttpBodyBeanSuivieApplication(String json) {
		return new Gson().fromJson(json, HttpBodyBeanSuivieApplication.class);
	}

	static public HttoBodyBeanInfoSpecifique deserializeHttpBodyBeanSpecifique(String json) {
		return new Gson().fromJson(json, HttoBodyBeanInfoSpecifique.class);
	}

	static public HttpBodyBeanDocAchemine deserializeHttpBodyBeanDocAchemine(String json) {
		return new Gson().fromJson(json, HttpBodyBeanDocAchemine.class);

	}

	static public HttpBodySuiviEnPersonne deserializeHttpBodyBeanSuiviEnPErsonne(String json) {
		return new Gson().fromJson(json, HttpBodySuiviEnPersonne.class);
	}

	static public HttpBodyBeanSuivieTelephonique deserializeHttpBodySuiviTelephonique(String json) {
		return new Gson().fromJson(json, HttpBodyBeanSuivieTelephonique.class);
	}

	// Application
	static public InfoApplication deserializeApplication(String json) {
		return new Gson().fromJson(json, InfoApplication.class);
	}

	static public HttpBodyBeanApplication deserializeHttpBodyApplication(String json) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		//Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
		return gson.fromJson(json, HttpBodyBeanApplication.class);
	}

	static public HttpBodyBeanExtrasPourApp deserializeHttpBodyExtraPourApp(String json) {
		return new Gson().fromJson(json, HttpBodyBeanExtrasPourApp.class);
	}
}
