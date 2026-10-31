package pixelbattle.heroes;

import pixelbattle.core.Hero;
import pixelbattle.core.Skill;
import pixelbattle.core.Target;
import pixelbattle.engine.Sprite;

import pixelbattle.core.Ultimate;
import pixelbattle.core.Fighter;

/** Лицар — міцний воїн ближнього бою. */
public class Demon extends Hero {

	public Demon() {
		super("Демон", 90, new Sprite("big_demon_idle_anim", 4, 4));

		addSkill(new Skill("Розріз", Target.ENEMY, 0, (user, target) -> {
			int dmg = target.takeDamage(random(10, 15));
			return user.getName() + " ріже " + target.getName() + ": " + dmg + " шкоди";
		}));

		addSkill(new Skill("Вогняний плювок", Target.ENEMY, 1, (user, target) -> {
			int dmg = target.takeDamage(random(15, 20));
			return user.getName() + " використовує вогняний плювок " + target.getName() + ": " + dmg + " шкоди";
		}));

		setUltimate(new Ultimate() {
			@Override public String getName() { return "Лавовий сплеск"; }
			@Override public String getDescription() { return "Кожному живому ворогу 25 шкоди"; }
			@Override public String activate(Fighter user, Fighter[] allies, Fighter[] enemies) {
				for (Fighter e : enemies) {
					if (e.isAlive()) {
						e.takeDamage(25);
					}
				}
				return user.getName() + " використав лавовий сплеск. Усі вороги отримали 25 шкоди";
			}
		});
	}
}