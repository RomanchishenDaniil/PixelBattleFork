package pixelbattle.heroes;

import pixelbattle.core.*;
import pixelbattle.engine.Sprite;

/** Лучниця — швидка й спритна. */
public class Archer extends Hero {

    public Archer() {
        super("Лучниця", 80, new Sprite("elf_f_idle_anim", 4, 4));

        addSkill(new Skill("Постріл", Target.ENEMY, 0, (user, target) ->
                user.getName() + " стріляє в " + target.getName() + ": "
                        + target.takeDamage(random(10, 16)) + " шкоди"));

        addSkill(new Skill("Подвійний постріл", Target.ENEMY, 1, (user, target) -> {
            int dmg1 = target.takeDamage(random(7, 11));
            int dmg2 = target.takeDamage(random(7, 11));
            return user.getName() + " стріляє два рази в " + target.getName() + ": " + (dmg1 + dmg2) + " шкоди";
        }));

        setUltimate(new Ultimate() {
            int counter = 0;
            int dmg = 0;
            @Override public String getName() { return "Злива стріл"; }
            @Override public String getDescription() { return "Кожному ЖИВОМУ ворогу 15 шкоди та оглушення на 1 хід"; }
            @Override public String activate(Fighter user, Fighter[] allies, Fighter[] enemies) {
                dmg = 0;
                for (Fighter e : enemies) {
                    if (e.isAlive()) {
                        for (int i = 0; i < 3 + counter; i++)
                            dmg += e.takeDamage(random(4, 8));
                    }
                }
                ++counter;
                return user.getName() + " використала зливу стріл. Усі вороги отримали " + dmg + " шкоди";
            }
        });

        // TODO 9: ультимейт «Злива стріл» — АНОНІМНИЙ КЛАС з полем-лічильником:
        //   кожен живий ворог отримує N стріл по random(4, 8) шкоди,
        //   де N = 3 при першому використанні, 4 — при другому, 5 — при третьому...
        //   (лічильник — поле всередині анонімного класу; знадобиться вкладений цикл).
    }

    @Override
    protected int modifyIncomingDamage(int damage) {
        return (chance(25)) ? 0 : damage;
    }
}
