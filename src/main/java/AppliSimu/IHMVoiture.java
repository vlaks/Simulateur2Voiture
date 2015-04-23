package AppliSimu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int metres) {
		return (int) (paramatreConversionMetresPixels * metres);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
        dessinerEtiquettePermis(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
        int yMetres = maVoiture.getY();
		int xPixel = calculerPositionPixels(xMetres);
        int yPixel = calculerPositionPixels(yMetres);
		contexteGraphique.fillRect(xPixel, yPixel, 30, 15);
	}


    private void dessinerEtiquettePermis(Graphics contexteGraphique) {
        int pointsPermis = maVoiture.getPointsPermis();
        Font fontPermis = new Font("Verdana", Font.BOLD, 18);
        contexteGraphique.setColor(Color.LIGHT_GRAY);
        contexteGraphique.fillRect(300, 420, 200, 80);
        contexteGraphique.setColor(Color.BLACK);
        contexteGraphique.drawString("Points de permis", 355, 450);
        contexteGraphique.setFont(fontPermis);
        contexteGraphique.drawString(Integer.toString(pointsPermis),390,480);

    }
	
}
