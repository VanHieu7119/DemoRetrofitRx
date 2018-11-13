package music_39.framgia.com.demoretrofitrx;

import com.google.gson.annotations.SerializedName;

public class Hero {
    @SerializedName("name")
    private String mName;

    @SerializedName("realname")
    private String mRealname;

    @SerializedName("team")
    private String mTeam;

    @SerializedName("firstappearance")
    private String mFirstappearance;

    @SerializedName("createdby")
    private String mCreatedby;

    @SerializedName("publisher")
    private String mPublisher;

    @SerializedName("imageurl")
    private String mImageurl;

    @SerializedName("bio")
    private String mBio;

    public Hero(String name, String realname, String team, String firstappearance, String createdby,
            String publisher, String imageurl, String bio) {
        mName = name;
        mRealname = realname;
        mTeam = team;
        mFirstappearance = firstappearance;
        mCreatedby = createdby;
        mPublisher = publisher;
        mImageurl = imageurl;
        mBio = bio;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRealname() {
        return mRealname;
    }

    public void setRealname(String realname) {
        mRealname = realname;
    }

    public String getTeam() {
        return mTeam;
    }

    public void setTeam(String team) {
        mTeam = team;
    }

    public String getFirstappearance() {
        return mFirstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        mFirstappearance = firstappearance;
    }

    public String getCreatedby() {
        return mCreatedby;
    }

    public void setCreatedby(String createdby) {
        mCreatedby = createdby;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        mPublisher = publisher;
    }

    public String getImageurl() {
        return mImageurl;
    }

    public void setImageurl(String imageurl) {
        mImageurl = imageurl;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }
}
