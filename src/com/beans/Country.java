package com.beans;

enum Continent
{
	Africa, Antarctica, Asia, NorthAmerica, SouthAmerica, Europe, Oceania,NULL; //Continents
}

public class Country {
    private String Code;
    private String Name;
    private Continent continent;
    private float Surfacearea;
    private String HeadofState;

    public Country() {}
    public Country (String Code, String Name, String continent, float Surfacearea, String HeadofState) {
        this.Code = Code;
        this.Name = Name;
        this.continent = Continent.valueOf(continent);
        this.Surfacearea = Surfacearea;
        this.HeadofState = HeadofState;
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getContinent() {
        return continent.toString();
    }

    public float getSurfacearea() {
        return Surfacearea;
    }

    public String getHeadofState() {
        return HeadofState;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setContinent(String continent) {
    	String continents = "";
    	String continentValue[] = continent.split(" ");
    	for(int i = 0; i < continentValue.length; i++) {
    		continents += continentValue[i];
    	}
    	if(continent.equals("") || continent.equals(null)){
    		this.continent = Continent.NULL;
    	}
    	else {
    		this.continent = Continent.valueOf(continents);
    
    	}
    }
 
    public void setSurfacearea(float Surfacearea) {
        this.Surfacearea = Surfacearea;
    }

    public void setHeadofState(String HeadofState) {
        this.HeadofState = HeadofState;
    }
    
}
