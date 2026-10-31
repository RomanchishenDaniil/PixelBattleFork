package pixelbattle.ultimates;
import pixelbattle.core.Fighter;
import pixelbattle.core.Ultimate;


 //TODO 8: ультимейт «Метеорит» — ЗВИЧАЙНИЙ (іменований) клас:

public class Meteor implements Ultimate {
	@Override public String getName() { return "Метеорит"; }
	@Override public String getDescription() { return "Кожному ЖИВОМУ ворогу 20-30 шкоди"; }
	int dmg;
	@Override public String activate(Fighter user, Fighter[] allies, Fighter[] enemies) {
		for (Fighter e : enemies) {
			if (e.isAlive()) {
				dmg = e.takeDamage(Fighter.random(20, 30));
			}
		}
		return user.getName() + " використав метеорит. Усі вороги отримали " + dmg + " шкоди";
	}
}