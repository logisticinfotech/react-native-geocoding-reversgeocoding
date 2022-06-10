package com.reactnativegeocodingreversegrocoding;

import android.location.Address;
import android.location.Geocoder;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@ReactModule(name = GeocodingReversegrocodingModule.NAME)
public class GeocodingReversegrocodingModule extends ReactContextBaseJavaModule {
  public static final String NAME = "GeocodingReversegrocoding";
  ReactApplicationContext reactContext;

  public GeocodingReversegrocodingModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void getLocationFromAddress(String strAddress, Promise promise) {
    Geocoder coder = new Geocoder(reactContext);
    List<Address> address;
    try {
      address = coder.getFromLocationName(strAddress, 5);
      if (address != null && address.size() > 0) {
        Address location = address.get(0);
        location.getLatitude();
        location.getLongitude();
        //
        WritableMap result = new WritableNativeMap();
        WritableMap jsonObject = new WritableNativeMap();
        //
        jsonObject.putDouble("lattitude", location.getLatitude());
        jsonObject.putDouble("longitude", location.getLongitude());
        result.putMap("result", jsonObject);

        promise.resolve(result);
      } else {
        // Pass empty JSON Map
        WritableMap result = new WritableNativeMap();
        WritableMap jsonObject = new WritableNativeMap();
        result.putMap("result", jsonObject);
        promise.resolve(result);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @ReactMethod
  public String getAddressFromLocation(double lat, double lang, Promise promise) {
    String strAdd = "";
    Geocoder geocoder = new Geocoder(reactContext, Locale.ENGLISH);
    try {
      List<Address> addresses = geocoder.getFromLocation(lat, lang, 1);
      if (addresses != null && addresses.size() > 0) {

        Address returnedAddress = addresses.get(0);
        String adminArea = "";
        String city = "";
        String state = "";
        String country = "";
        String countryCode = "";
        String featureName = "";
        String formattedAddress = "";
        String locality = "";
        String strLat = "";
        String strLang = "";
        String postalCode = "";
        String streetName = "";
        String streetNumber = "";
        String subAdminArea = "";
        String subLocality = "";

        if (returnedAddress.getAdminArea() != null) {
          adminArea = returnedAddress.getAdminArea();
        }
        if (returnedAddress.getLocality() != null) {
          city = returnedAddress.getLocality();
        }
        if (returnedAddress.getAdminArea() != null) {
          state = returnedAddress.getAdminArea();
        }
        if (returnedAddress.getCountryName() != null) {
          country = returnedAddress.getCountryName();
        }
        if (returnedAddress.getCountryCode() != null) {
          countryCode = returnedAddress.getCountryCode();
        }
        if (returnedAddress.getFeatureName() != null) {
          featureName = returnedAddress.getFeatureName();
        }
        if (returnedAddress.getAddressLine(0) != null) {
          formattedAddress = returnedAddress.getAddressLine(0);
        }
        if (returnedAddress.getLocality() != null) {
          locality = returnedAddress.getLocality();
        }
        if (String.valueOf(returnedAddress.getLatitude()) != null) {
          strLat = String.valueOf(returnedAddress.getLatitude());
        }
        if (String.valueOf(returnedAddress.getLongitude()) != null) {
          strLang = String.valueOf(returnedAddress.getLongitude());
        }
        if (returnedAddress.getPostalCode() != null) {
          postalCode = returnedAddress.getPostalCode();
        }
        if (returnedAddress.getThoroughfare() != null) {
          streetName = returnedAddress.getThoroughfare();
        }
        if (returnedAddress.getSubThoroughfare() != null) {
          streetNumber = returnedAddress.getSubThoroughfare();
        }
        if (returnedAddress.getSubAdminArea() != null) {
          subAdminArea = returnedAddress.getSubAdminArea();
        }
        if (returnedAddress.getSubLocality() != null) {
          subLocality = returnedAddress.getSubLocality();
        }
        //
        WritableMap result = new WritableNativeMap();
        WritableMap jsonObject = new WritableNativeMap();
        WritableMap jsonObjectPosition = new WritableNativeMap();
        //
        jsonObject.putString("adminArea", adminArea);
        jsonObject.putString("city", city);
        jsonObject.putString("state", state);
        jsonObject.putString("country", country);
        jsonObject.putString("countryCode", countryCode);
        jsonObject.putString("feature", featureName);
        jsonObject.putString("formattedAddress", formattedAddress);
        jsonObject.putString("locality", locality);
        //
        jsonObjectPosition.putString("lat", strLat);
        jsonObjectPosition.putString("lng", strLang);
        jsonObject.putMap("position", jsonObjectPosition);
        //
        jsonObject.putString("postalCode", postalCode);
        jsonObject.putString("streetName", streetName);
        jsonObject.putString("streetNumber", streetNumber);
        jsonObject.putString("subAdminArea", subAdminArea);
        jsonObject.putString("subLocality", subLocality);
        //
        result.putMap("result", jsonObject);

        promise.resolve(result);
      } else {
        // Pass empty JSON Map
        WritableMap result = new WritableNativeMap();
        WritableMap jsonObject = new WritableNativeMap();
        result.putMap("result", jsonObject);
        promise.resolve(result);
      }
    } catch (Exception e) {
      e.printStackTrace();
      // Pass empty JSON Map
      WritableMap result = new WritableNativeMap();
      WritableMap jsonObject = new WritableNativeMap();
      result.putMap("result", jsonObject);
      promise.resolve(result);
    }
    return strAdd;
  }
}
