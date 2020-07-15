package cst438hw2.domain;

public class CityInfo {
	
	 long id;
	 String name;
	 String countryCode;
	 String countryName;
	 String district;
	 int population;
	 double temp;
	 String time;
	 
	 public CityInfo() {
		 
	 }
	 
	 public CityInfo(City city, String countryName, double temp, String time) {
		 this.id = city.getId();
		 this.name = city.getName();
		 this.countryCode = city.getCountryCode();
		 this.countryName = countryName;
		 this.district = city.getDistrict();
		 this.population = city.getPopulation();
		 this.temp = temp;
		 this.time = time;
	 }

	public CityInfo(long id, String name, String countryCode, String countryName, String district, int population,
			double temp, String time) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.district = district;
		this.population = population;
		this.temp = temp;
		this.time = time;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityInfo other = (CityInfo) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (population != other.population)
			return false;
		if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CityInfo [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", district=" + district + ", population=" + population + ", temp=" + temp + ", time=" + time + "]";
	}
	 
	 
}
