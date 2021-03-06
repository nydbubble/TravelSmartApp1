package com.example.nydia.travelsmartapp.models;


import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.example.nydia.travelsmartapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

/**
 * Created by nydia on 3/27/18.
 */


public class TrafficCamera implements Parcelable {

    @SerializedName("CameraID")
    @Expose
    private String cameraID;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("ImageLink")
    @Expose
    private String imageLink;

    public TrafficCamera(String cameraID, Double latitude, Double longitude, String imageLink){
        this.cameraID = cameraID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageLink = imageLink;
    }

    protected TrafficCamera(Parcel in) {
        cameraID = in.readString();
        if (in.readByte() == 0) {
            latitude = null;
        } else {
            latitude = in.readDouble();
        }
        if (in.readByte() == 0) {
            longitude = null;
        } else {
            longitude = in.readDouble();
        }
        imageLink = in.readString();
    }

    public static final Creator<TrafficCamera> CREATOR = new Creator<TrafficCamera>() {
        @Override
        public TrafficCamera createFromParcel(Parcel in) {
            return new TrafficCamera(in);
        }

        @Override
        public TrafficCamera[] newArray(int size) {
            return new TrafficCamera[size];
        }
    };

    public String getCameraID() {
        return cameraID;
    }

    public void setCameraID(String cameraID) {
        this.cameraID = cameraID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cameraID);
        if (latitude == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(latitude);
        }
        if (longitude == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(longitude);
        }
        parcel.writeString(imageLink);
    }
}