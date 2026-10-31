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
 /*
 *   - getName()        → "Метеорит"
 *   - getDescription() → короткий опис
 *   - activate(...)    → кожному живому ворогу Fighter.random(20, 30) шкоди;
 *                        поверніть рядок для журналу (наприклад, загальну шкоду).
 *
 *   Потрібні імпорти: pixelbattle.core.Fighter, pixelbattle.core.Ultimate.
 *   Зверніть увагу: Meteor НЕ є бійцем, тому random(...) тут викликається
 *   через ім'я класу: Fighter.random(20, 30).
 *
 *   Потім підключіть ультимейт у конструкторі Mage: setUltimate(new Meteor());
 */
