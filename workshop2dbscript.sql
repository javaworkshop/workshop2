-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema workshop2db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `workshop2db` ;

-- -----------------------------------------------------
-- Schema workshop2db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workshop2db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `workshop2db` ;

-- -----------------------------------------------------
-- Table `workshop2db`.`klant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`klant` (
  `klant_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `voornaam` VARCHAR(60) NOT NULL COMMENT '',
  `achternaam` VARCHAR(60) NOT NULL COMMENT '',
  `emailadres` VARCHAR(320) NOT NULL COMMENT '',
  `telefoonnummer` VARCHAR(10) NULL COMMENT '',
  `rekeninghouder` VARCHAR(60) NULL COMMENT '',
  `iban` VARCHAR(34) NULL COMMENT '',
  `opmerkingen` LONGTEXT NULL COMMENT '',
  PRIMARY KEY (`klant_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`adres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`adres` (
  `adres_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `straatnaam` VARCHAR(30) NULL COMMENT '',
  `huisnummer` VARCHAR(6) NULL COMMENT '',
  `postcode` VARCHAR(6) NULL COMMENT '',
  `woonplaats` VARCHAR(30) NULL COMMENT '',
  PRIMARY KEY (`adres_id`)  COMMENT '',
  UNIQUE INDEX `UNIEK_ADRES` (`postcode` ASC, `huisnummer` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`planning`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`planning` (
  `planning_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `startdatum` DATETIME NOT NULL COMMENT '',
  `einddatum` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`planning_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`bestelling`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`bestelling` (
  `bestelling_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `totaalprijs_excl_btw` INT UNSIGNED NULL COMMENT '',
  `totaalprijs_incl_btw` INT UNSIGNED NULL COMMENT '',
  `klant_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  `opmerkingen` LONGTEXT NULL COMMENT '',
  `voltooid` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `bestellingbon` LONGBLOB NULL COMMENT '',
  `werkbon` LONGBLOB NULL COMMENT '',
  `planning_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  PRIMARY KEY (`bestelling_id`)  COMMENT '',
  INDEX `klant_bestelling_fk_idx` (`klant_id` ASC)  COMMENT '',
  INDEX `planning_bestelling_fk_idx` (`planning_id` ASC)  COMMENT '',
  CONSTRAINT `klant_bestelling_fk`
    FOREIGN KEY (`klant_id`)
    REFERENCES `workshop2db`.`klant` (`klant_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `planning_bestelling_fk`
    FOREIGN KEY (`planning_id`)
    REFERENCES `workshop2db`.`planning` (`planning_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`factuur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`factuur` (
  `factuur_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `bestelling_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `totaalprijs_excl_btw` INT UNSIGNED NULL COMMENT '',
  `totaalprijs_incl_btw` INT UNSIGNED NULL COMMENT '',
  `klant_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  `opmerkingen` LONGTEXT NULL COMMENT '',
  `betaald` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `uiterste_betaaldatum` DATE NULL COMMENT '',
  `betaaldatum` DATE NULL COMMENT '',
  `bestand` LONGBLOB NULL COMMENT '',
  PRIMARY KEY (`factuur_id`)  COMMENT '',
  INDEX `bestelling_factuur_fk_idx` (`bestelling_id` ASC)  COMMENT '',
  INDEX `klant_factuur_fk_idx` (`klant_id` ASC)  COMMENT '',
  CONSTRAINT `bestelling_factuur_fk`
    FOREIGN KEY (`bestelling_id`)
    REFERENCES `workshop2db`.`bestelling` (`bestelling_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `klant_factuur_fk`
    FOREIGN KEY (`klant_id`)
    REFERENCES `workshop2db`.`klant` (`klant_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`productgroep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`productgroep` (
  `productgroep_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `groep` VARCHAR(40) NOT NULL COMMENT '',
  PRIMARY KEY (`productgroep_id`)  COMMENT '',
  UNIQUE INDEX `groep_UNIQUE` (`groep` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`eenheid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`eenheid` (
  `eenheid_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `eenheid` VARCHAR(25) NOT NULL COMMENT '',
  PRIMARY KEY (`eenheid_id`)  COMMENT '',
  UNIQUE INDEX `eenheid_UNIQUE` (`eenheid` ASC)  COMMENT '')
ENGINE = InnoDB
COMMENT = 'Een eenheid is bijvoorbeeld vierkante meter of meter of een enkel product.';


-- -----------------------------------------------------
-- Table `workshop2db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`product` (
  `artikelnummer` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `naam` VARCHAR(60) NOT NULL COMMENT '',
  `omschrijving` LONGTEXT NULL COMMENT '',
  `productgroep_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  `prijs_excl_btw_per_eenheid` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '',
  `eenheid_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  PRIMARY KEY (`artikelnummer`)  COMMENT '',
  INDEX `productgroep_fk_idx` (`productgroep_id` ASC)  COMMENT '',
  INDEX `eenheid_fk_idx` (`eenheid_id` ASC)  COMMENT '',
  CONSTRAINT `productgroep_fk`
    FOREIGN KEY (`productgroep_id`)
    REFERENCES `workshop2db`.`productgroep` (`productgroep_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `eenheid_fk`
    FOREIGN KEY (`eenheid_id`)
    REFERENCES `workshop2db`.`eenheid` (`eenheid_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`leverancier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`leverancier` (
  `leverancier_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `adres_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  `bedrijfsnaam` VARCHAR(60) NOT NULL COMMENT '',
  `website` VARCHAR(40) NULL COMMENT '',
  `emailadres` VARCHAR(320) NULL COMMENT '',
  `rekeninghouder` VARCHAR(60) NULL COMMENT '',
  `iban` VARCHAR(34) NULL COMMENT '',
  `opmerkingen` LONGTEXT NULL COMMENT '',
  PRIMARY KEY (`leverancier_id`)  COMMENT '',
  INDEX `adres_leverancier_fk_idx` (`adres_id` ASC)  COMMENT '',
  CONSTRAINT `adres_leverancier_fk`
    FOREIGN KEY (`adres_id`)
    REFERENCES `workshop2db`.`adres` (`adres_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`vloertype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`vloertype` (
  `vloertype_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `type` VARCHAR(40) NOT NULL COMMENT '',
  PRIMARY KEY (`vloertype_id`)  COMMENT '',
  UNIQUE INDEX `type_UNIQUE` (`type` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`vloer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`vloer` (
  `artikelnummer` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `vloertype_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  `materiaal` VARCHAR(45) NOT NULL COMMENT '',
  INDEX `vloertype_fk_idx` (`vloertype_id` ASC)  COMMENT '',
  INDEX `artikelnummer_vloer_fk_idx` (`artikelnummer` ASC)  COMMENT '',
  PRIMARY KEY (`artikelnummer`)  COMMENT '',
  CONSTRAINT `vloertype_fk`
    FOREIGN KEY (`vloertype_id`)
    REFERENCES `workshop2db`.`vloertype` (`vloertype_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `artikelnummer_vloer_fk`
    FOREIGN KEY (`artikelnummer`)
    REFERENCES `workshop2db`.`product` (`artikelnummer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`leverancier_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`leverancier_has_product` (
  `artikelnummer` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `leverancier_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  UNIQUE INDEX `UNIEK_PRODUCTLEVERANCIER` (`artikelnummer` ASC, `leverancier_id` ASC)  COMMENT '',
  INDEX `leverancier_product_fk_idx` (`leverancier_id` ASC)  COMMENT '',
  INDEX `product_leverancier_fk_idx` (`artikelnummer` ASC)  COMMENT '',
  CONSTRAINT `product_leverancier_fk`
    FOREIGN KEY (`artikelnummer`)
    REFERENCES `workshop2db`.`product` (`artikelnummer`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `leverancier_product_fk`
    FOREIGN KEY (`leverancier_id`)
    REFERENCES `workshop2db`.`leverancier` (`leverancier_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`bestellingdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`bestellingdetails` (
  `bestelling_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `artikelnummer` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `hoeveelheid` INT UNSIGNED NOT NULL COMMENT '',
  `prijscorrectie` DOUBLE UNSIGNED NOT NULL DEFAULT 1.0 COMMENT '',
  INDEX `bestelling_bestellingdetails_fk_idx` (`bestelling_id` ASC)  COMMENT '',
  INDEX `artikelnummer_bestellingdetails_fk_idx` (`artikelnummer` ASC)  COMMENT '',
  UNIQUE INDEX `UNIEK_BESTELLINGDETAILS` (`bestelling_id` ASC, `artikelnummer` ASC)  COMMENT '',
  PRIMARY KEY (`bestelling_id`)  COMMENT '',
  CONSTRAINT `bestelling_bestellingdetails_fk`
    FOREIGN KEY (`bestelling_id`)
    REFERENCES `workshop2db`.`bestelling` (`bestelling_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `artikelnummer_bestellingdetails_fk`
    FOREIGN KEY (`artikelnummer`)
    REFERENCES `workshop2db`.`product` (`artikelnummer`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`levering`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`levering` (
  `levering_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `leverancier_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `leverdatum` DATETIME NOT NULL COMMENT '',
  `geleverd` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `leveradres` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  PRIMARY KEY (`levering_id`)  COMMENT '',
  INDEX `leveradres_fk_idx` (`leveradres` ASC)  COMMENT '',
  INDEX `leverancier_levering_fk_idx` (`leverancier_id` ASC)  COMMENT '',
  CONSTRAINT `leveradres_fk`
    FOREIGN KEY (`leveradres`)
    REFERENCES `workshop2db`.`adres` (`adres_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `leverancier_levering_fk`
    FOREIGN KEY (`leverancier_id`)
    REFERENCES `workshop2db`.`leverancier` (`leverancier_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`factuurdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`factuurdetails` (
  `factuur_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `artikelnummer` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `hoeveelheid` INT UNSIGNED NOT NULL COMMENT '',
  `prijscorrectie` DOUBLE UNSIGNED NOT NULL DEFAULT 1.0 COMMENT '',
  INDEX `factuur_factuurdetails_fk_idx` (`factuur_id` ASC)  COMMENT '',
  INDEX `artikelnummer_factuurdetails_fk_idx` (`artikelnummer` ASC)  COMMENT '',
  UNIQUE INDEX `UNIEK_FACTUURDETAILS` (`factuur_id` ASC, `artikelnummer` ASC)  COMMENT '',
  PRIMARY KEY (`factuur_id`)  COMMENT '',
  CONSTRAINT `factuur_factuurdetails_fk`
    FOREIGN KEY (`factuur_id`)
    REFERENCES `workshop2db`.`factuur` (`factuur_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `artikelnummer_factuurdetails_fk`
    FOREIGN KEY (`artikelnummer`)
    REFERENCES `workshop2db`.`product` (`artikelnummer`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`leveringdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`leveringdetails` (
  `levering_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `artikelnummer` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `hoeveelheid` INT UNSIGNED NOT NULL COMMENT '',
  `prijs` INT UNSIGNED NOT NULL COMMENT '',
  INDEX `levering_leveringdetails_fk_idx` (`levering_id` ASC)  COMMENT '',
  UNIQUE INDEX `UNIEK_LEVERINGDETAILS` (`artikelnummer` ASC, `levering_id` ASC)  COMMENT '',
  INDEX `artikelnummer_leveringdetails_fk_idx` (`artikelnummer` ASC)  COMMENT '',
  PRIMARY KEY (`levering_id`)  COMMENT '',
  CONSTRAINT `levering_leveringdetails_fk`
    FOREIGN KEY (`levering_id`)
    REFERENCES `workshop2db`.`levering` (`levering_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `artikelnummer_leveringdetails_fk`
    FOREIGN KEY (`artikelnummer`)
    REFERENCES `workshop2db`.`product` (`artikelnummer`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`contactpersoon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`contactpersoon` (
  `contactpersoon_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `leverancier_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `voornaam` VARCHAR(60) NOT NULL COMMENT '',
  `achternaam` VARCHAR(60) NOT NULL COMMENT '',
  `emailadres` VARCHAR(320) NOT NULL COMMENT '',
  `telefoonnummer` VARCHAR(10) NULL COMMENT '',
  PRIMARY KEY (`contactpersoon_id`, `leverancier_id`)  COMMENT '',
  INDEX `leverancier_contactpersoon_fk_idx` (`leverancier_id` ASC)  COMMENT '',
  CONSTRAINT `leverancier_contactpersoon_fk`
    FOREIGN KEY (`leverancier_id`)
    REFERENCES `workshop2db`.`leverancier` (`leverancier_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`factuur_levering`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`factuur_levering` (
  `factuur_levering_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `levering_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `totaalprijs` INT UNSIGNED NULL COMMENT '',
  `uiterste_betaaldatum` DATE NULL COMMENT '',
  `betaaldatum` DATE NULL COMMENT '',
  `opmerkingen` LONGTEXT NULL COMMENT '',
  `betaald` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`factuur_levering_id`)  COMMENT '',
  INDEX `levering_factuur_fk_idx` (`levering_id` ASC)  COMMENT '',
  UNIQUE INDEX `levering_id_UNIQUE` (`levering_id` ASC)  COMMENT '',
  CONSTRAINT `levering_factuur_fk`
    FOREIGN KEY (`levering_id`)
    REFERENCES `workshop2db`.`levering` (`levering_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`login` (
  `login_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `login` VARCHAR(60) NOT NULL COMMENT '',
  `wachtwoord` VARCHAR(32) NOT NULL COMMENT '',
  `salt` VARCHAR(32) NULL COMMENT '',
  PRIMARY KEY (`login_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`autorisatieniveau`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`autorisatieniveau` (
  `autorisatieniveau_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `autorisatieniveau` VARCHAR(30) NOT NULL COMMENT '',
  PRIMARY KEY (`autorisatieniveau_id`)  COMMENT '',
  UNIQUE INDEX `autorisatieniveau_UNIQUE` (`autorisatieniveau` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`gebruiker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`gebruiker` (
  `gebruiker_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `login_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `voornaam` VARCHAR(60) NOT NULL COMMENT '',
  `achternaam` VARCHAR(60) NOT NULL COMMENT '',
  `autorisatieniveau_id` BIGINT(20) UNSIGNED NULL COMMENT '',
  PRIMARY KEY (`gebruiker_id`, `login_id`)  COMMENT '',
  INDEX `login_fk_idx` (`login_id` ASC)  COMMENT '',
  INDEX `autorisatieniveau_fk_idx` (`autorisatieniveau_id` ASC)  COMMENT '',
  UNIQUE INDEX `login_id_UNIQUE` (`login_id` ASC)  COMMENT '',
  CONSTRAINT `login_fk`
    FOREIGN KEY (`login_id`)
    REFERENCES `workshop2db`.`login` (`login_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `autorisatieniveau_fk`
    FOREIGN KEY (`autorisatieniveau_id`)
    REFERENCES `workshop2db`.`autorisatieniveau` (`autorisatieniveau_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`btw`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`btw` (
  `btw_id` TINYINT(1) UNSIGNED NOT NULL COMMENT '',
  `waarde` DOUBLE UNSIGNED NOT NULL COMMENT '',
  PRIMARY KEY (`btw_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workshop2db`.`klant_has_adres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `workshop2db`.`klant_has_adres` (
  `klant_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `adres_id` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  INDEX `klant_adres_fk_idx` (`klant_id` ASC)  COMMENT '',
  INDEX `adres_klant_fk_idx` (`adres_id` ASC)  COMMENT '',
  UNIQUE INDEX `UNIEK_KLANT_HAS_ADRES` (`klant_id` ASC, `adres_id` ASC)  COMMENT '',
  CONSTRAINT `klant_adres_fk`
    FOREIGN KEY (`klant_id`)
    REFERENCES `workshop2db`.`klant` (`klant_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `adres_klant_fk`
    FOREIGN KEY (`adres_id`)
    REFERENCES `workshop2db`.`adres` (`adres_id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `workshop2db` ;

-- -----------------------------------------------------
-- procedure calcFactuurTotaalPrijs
-- -----------------------------------------------------

DELIMITER $$
USE `workshop2db`$$
CREATE PROCEDURE `calcFactuurTotaalPrijs` (IN factuurIdParam BIGINT)
BEGIN
	DECLARE totaalPrijsExclBtwVar INT;
    DECLARE productPrijsExclBtwVar INT;
    DECLARE artikelnummerVar BIGINT;
    DECLARE btwVar DECIMAL;
    DECLARE doneVar INT DEFAULT FALSE; 
    DECLARE hoeveelheidVar INT;
    DECLARE prijscorrectieVar DECIMAL;
    
    DECLARE factuurDetailsCursor CURSOR FOR SELECT artikelnummer, hoeveelheid, prijscorrectie FROM factuurdetails WHERE factuurdetails.factuur_id = factuurIdParam;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneVar = TRUE;
    OPEN factuurDetailsCursor;
    
    read_loop: LOOP
    FETCH factuurDetailsCursor INTO artikelnummerVar, hoeveelheidVar, prijscorrectieVar;
    IF doneVar THEN
		LEAVE read_loop;
	END IF;
    SELECT prijs_excl_btw_per_eenheid FROM product WHERE artikelnummerVar = product.artikelnummer INTO productPrijsExclBtwVar;
    SET totaalPrijsExclBtwVar = totaalPrijsExclBtwVar + productPrijsExclBtwVar * prijscorrectieVar * hoeveelheidVar;
    END LOOP;
    
    CLOSE factuurDetailsCursor;
    
    UPDATE factuur SET totaalprijs_excl_btw = totaalprijsExclBtwVar WHERE factuur_id = factuurIdParam;
    SELECT waarde FROM btw WHERE btw_id = 1 INTO btwVar;
    SET @totaalPrijsInclBtwVar = totaalprijsExclBtwVar * btwVar;
    UPDATE factuur SET totaalprijs_incl_btw = @totaalPrijsInclBtwVar WHERE factuur_id = factuurIdParam;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure calcBestellingTotaalPrijs
-- -----------------------------------------------------

DELIMITER $$
USE `workshop2db`$$
CREATE PROCEDURE `calcBestellingTotaalPrijs` (IN bestellingIdParam BIGINT)
BEGIN
	DECLARE totaalPrijsExclBtwVar INT;
    DECLARE productPrijsExclBtwVar INT;
    DECLARE artikelnummerVar BIGINT;
    DECLARE btwVar DECIMAL;
    DECLARE doneVar INT DEFAULT FALSE; 
    DECLARE hoeveelheidVar INT;
    DECLARE prijscorrectieVar DECIMAL;
    
    DECLARE bestellingDetailsCursor CURSOR FOR SELECT artikelnummer, hoeveelheid, prijscorrectie FROM bestellingdetails WHERE bestellingdetails.bestelling_id = bestellingIdParam;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneVar = TRUE;
    OPEN bestellingDetailsCursor;
    
    read_loop: LOOP
    FETCH bestellingDetailsCursor INTO artikelnummerVar, hoeveelheidVar, prijscorrectieVar;
    IF doneVar THEN
		LEAVE read_loop;
	END IF;
    SELECT prijs_excl_btw_per_eenheid FROM product WHERE artikelnummerVar = product.artikelnummer INTO productPrijsExclBtwVar;
    SET totaalPrijsExclBtwVar = totaalPrijsExclBtwVar + productPrijsExclBtwVar * prijscorrectieVar * hoeveelheidVar;
    END LOOP;
    
    CLOSE bestellingDetailsCursor;
    
    UPDATE bestelling SET totaalprijs_excl_btw = totaalprijsExclBtwVar WHERE bestelling_id = bestellingIdParam;
    SELECT waarde FROM btw WHERE btw_id = 1 INTO btwVar;
    SET @totaalPrijsInclBtwVar = totaalprijsExclBtwVar * btwVar;
    UPDATE bestelling SET totaalprijs_incl_btw = @totaalPrijsInclBtwVar WHERE bestelling_id = bestellingIdParam;
END
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure calcFactuurLeveringTotaalPrijs
-- -----------------------------------------------------

DELIMITER $$
USE `workshop2db`$$
CREATE PROCEDURE `calcFactuurLeveringTotaalPrijs` (IN leveringIdParam BIGINT)
BEGIN
	DECLARE totaalprijsVar INT;
    DECLARE doneVar INT DEFAULT FALSE; 
    DECLARE hoeveelheidVar INT;
    DECLARE prijsVar INT;
    
    DECLARE leveringdetailsCursor CURSOR FOR SELECT hoeveelheid, prijs FROM leveringdetails WHERE leveringdetails.levering_id = leveringIdParam;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET doneVar = TRUE;
    OPEN leveringdetailsCursor;
    
    read_loop: LOOP
    FETCH leveringdetailsCursor INTO hoeveelheidVar, prijsVar;
    IF doneVar THEN
		LEAVE read_loop;
	END IF;    
    SET totaalprijsVar = totaalprijsVar + prijsVar * hoeveelheidVar;
    END LOOP;
    
    CLOSE leveringdetailsCursor;
    
    UPDATE factuur_levering SET totaalprijs = totaalprijsVar WHERE levering_id = leveringIdParam;
END
$$

DELIMITER ;
USE `workshop2db`;

DELIMITER $$
USE `workshop2db`$$
CREATE TRIGGER `bestelling_AFTER_INSERT` AFTER INSERT ON `bestelling` FOR EACH ROW
BEGIN
	CALL calcBestellingTotaalPrijs(NEW.bestelling_id);
END$$

USE `workshop2db`$$
CREATE TRIGGER `factuur_AFTER_INSERT` AFTER INSERT ON `factuur` FOR EACH ROW
BEGIN
	CALL calcFactuurTotaalPrijs(NEW.factuur_id);
END$$

USE `workshop2db`$$
CREATE TRIGGER `factuur_levering_AFTER_INSERT` AFTER INSERT ON `factuur_levering` FOR EACH ROW
BEGIN
	CALL calcFactuurLeveringTotaalPrijs(NEW.levering_id);
END
$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `workshop2db`.`productgroep`
-- -----------------------------------------------------
START TRANSACTION;
USE `workshop2db`;
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'VLOER');
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'ONDERVLOER');
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'ONDERHOUDSPRODUCT');
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'HYGROMETER');
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'DROOGLOOPMAT');
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'LUCHTBEVOCHTIGER');
INSERT INTO `workshop2db`.`productgroep` (`productgroep_id`, `groep`) VALUES (DEFAULT, 'PLINT');

COMMIT;


-- -----------------------------------------------------
-- Data for table `workshop2db`.`eenheid`
-- -----------------------------------------------------
START TRANSACTION;
USE `workshop2db`;
INSERT INTO `workshop2db`.`eenheid` (`eenheid_id`, `eenheid`) VALUES (DEFAULT, 'VIERKANTE_METER');
INSERT INTO `workshop2db`.`eenheid` (`eenheid_id`, `eenheid`) VALUES (DEFAULT, 'METER');
INSERT INTO `workshop2db`.`eenheid` (`eenheid_id`, `eenheid`) VALUES (DEFAULT, 'ENKEL_PRODUCT');

COMMIT;


-- -----------------------------------------------------
-- Data for table `workshop2db`.`vloertype`
-- -----------------------------------------------------
START TRANSACTION;
USE `workshop2db`;
INSERT INTO `workshop2db`.`vloertype` (`vloertype_id`, `type`) VALUES (DEFAULT, 'LAMINAAT');
INSERT INTO `workshop2db`.`vloertype` (`vloertype_id`, `type`) VALUES (DEFAULT, 'PLAVUIZEN');
INSERT INTO `workshop2db`.`vloertype` (`vloertype_id`, `type`) VALUES (DEFAULT, 'VINYL');
INSERT INTO `workshop2db`.`vloertype` (`vloertype_id`, `type`) VALUES (DEFAULT, 'PARKET');
INSERT INTO `workshop2db`.`vloertype` (`vloertype_id`, `type`) VALUES (DEFAULT, 'BETON');

COMMIT;


-- -----------------------------------------------------
-- Data for table `workshop2db`.`autorisatieniveau`
-- -----------------------------------------------------
START TRANSACTION;
USE `workshop2db`;
INSERT INTO `workshop2db`.`autorisatieniveau` (`autorisatieniveau_id`, `autorisatieniveau`) VALUES (DEFAULT, 'BEHEERDER');
INSERT INTO `workshop2db`.`autorisatieniveau` (`autorisatieniveau_id`, `autorisatieniveau`) VALUES (DEFAULT, 'LEGGER');

COMMIT;


-- -----------------------------------------------------
-- Data for table `workshop2db`.`btw`
-- -----------------------------------------------------
START TRANSACTION;
USE `workshop2db`;
INSERT INTO `workshop2db`.`btw` (`btw_id`, `waarde`) VALUES (1, 1.21);

COMMIT;

