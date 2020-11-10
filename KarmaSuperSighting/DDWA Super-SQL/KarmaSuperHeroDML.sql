 USE KarmaSuperHeroTestDB;
 USE KarmaSuperHeroDB;
INSERT INTO Superpower(`superpowerId`, `name`) VALUES 
   (1, "Telekinesis"),
   (2, "Teleportation");
    
INSERT INTO Location(name,description,address,city,state,zipcode,latitude,longitude)  VALUES
	("Grand Central Terminal","public subway", "89 E 42nd St,", "New York City","NY","10017",42.369160,-73.977310),
	("Flat Iron Building","building", "175 5th Ave,", "New York City","NY","10010",40.727760,-73.259956),
	("Batman’s House","Batman lives on top of the freedom tower.", "285 Fulton Street,", "New York City", "NY","10006",40.713122, -74.013363);
 USE KarmaSuperHeroDB;
    INSERT INTO Hero(`name`, `description`, `superpowerId`)  VALUES
    ("The InvisibleEntity","Can turn move things with mind. Alias Chucker",2),
    ("Zen","Can read and control people’s minds and teleport. Alias Mandy",2);
 
    INSERT INTO Organization(`name`, locationId, `description`, phoneNum) VALUES
	("The Post", 1, " A lotus looking building that is made of steel. Finger prints needed to enter.", 13125661234),
    ("The Way", 2, "Far away in the middle of BadLands, SandHouse blends right into the Environment.", 15983598649);
  
    INSERT INTO HeroOrganization(heroId, OrganizationId) VALUES
	(1,1),
	(1,2),
    (2,1);
    

    INSERT INTO Sighting(`date`,heroId,locationId)  VALUES
	('2020-01-01',1,1),
	('2020-01-02',2,1);
  