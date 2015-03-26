package beans;



import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable{

	
	String PlayerName;
	int PlayerScore;
	
	public Player(String playerName, int playerScore) {
		
		PlayerName = playerName;
		PlayerScore = playerScore;
	}
	
	public Player(){
		
	}
	
	public Player(Parcel in) {
		
		PlayerName=in.readString();
		
		PlayerScore=in.readInt();
		
		
	}
		
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { 
		public Player createFromParcel(Parcel in) { 
			return new Player(in); 
		}   
		public Player[] newArray(int size) { 
			return new Player[size]; 
		}
	};
	
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		arg0.writeString(PlayerName);
		arg0.writeInt(PlayerScore);
		
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public int getPlayerScore() {
		return PlayerScore;
	}
	public void setPlayerScore(int playerScore) {
		PlayerScore = playerScore;
	}
	
	
	
}
