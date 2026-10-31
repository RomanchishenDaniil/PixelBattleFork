package pixelbattle.enemies;

import pixelbattle.core.Enemy;
import pixelbattle.core.Skill;
import pixelbattle.core.Target;
import pixelbattle.engine.Sprite;

public class Skeleton extends Enemy {

	public Skeleton() {
		super("Скелет", 50, new Sprite("skelet_idle_anim", 4, 6));

		addSkill(new Skill("Кістяний удар", Target.ENEMY, 0, (user, target) ->
				user.getName() + " б'є " + target.getName() + ": "
						+ target.takeDamage(random(8, 12)) + " шкоди"));
	}

	@Override
	protected int modifyIncomingDamage(int damage) {
		return (getHp() > 1 && damage >= getHp()) ? Math.min(damage, getHp() - 1) : damage;
	}
}