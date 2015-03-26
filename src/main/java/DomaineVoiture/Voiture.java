package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	private int x;
	private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int x, int y, int direction,int vitesse) {
		this.x = x;
		this.y = y;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = direction;
	}

	public void miseAJourPosition() {
		miseAJourPositionX();
        miseAJourPositionY();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
        if (directionEnDegres == 0)
            x += vitesseMetreSeconde;
        else if(directionEnDegres == 90) {
            x=x;
        }
        else if(directionEnDegres == 270) {
            x=x;
        }
        else if(directionEnDegres == 180) {
            x -= vitesseMetreSeconde;
        }
        else{
            double angleRadian = (Math.PI * directionEnDegres)/180;
            x += (int) (Math.cos(angleRadian) * vitesseMetreSeconde);
        }

        if (x > 1000)
            x = 1000;
        else if (x < 0)
            x = 0;
    }

    private void miseAJourPositionY() {
        if (directionEnDegres == 90)
            y += vitesseMetreSeconde;
        else if(directionEnDegres == 0) {
            y=y;
        }
        else if(directionEnDegres == 180) {
            y=y;
        }
        else if(directionEnDegres == 270) {
            y -= vitesseMetreSeconde;
        }
        else {
            double angleRadian = (Math.PI * directionEnDegres)/180;
            y += (int) (Math.sin(angleRadian) * vitesseMetreSeconde);
        }
    }

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getX() {
		return x;
	}

    public int getY() {
        return y;
    }

	public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

	public Object getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;
		
	}

    public void tournerDroite(){
        directionEnDegres += 10;
        directionEnDegres = directionEnDegres % 360;
    }

    public void tournerGauche(){
        directionEnDegres -= 10;
        directionEnDegres = directionEnDegres % 360;
    }

	public void inverserDirection() {
		directionEnDegres +=180 ;
		directionEnDegres = directionEnDegres % 360;
		
	}

	public Object getDirection() {
	return directionEnDegres;
	}

	
}
