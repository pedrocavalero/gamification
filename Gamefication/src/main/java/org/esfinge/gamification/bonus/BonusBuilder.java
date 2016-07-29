package org.esfinge.gamification.bonus;

import java.util.function.BiFunction;

import org.esfinge.gamification.achievement.Achievement;
import org.esfinge.gamification.listener.EvaluationAchievementListener;
import org.esfinge.gamification.mechanics.Game;

public class BonusBuilder {

	Game game;
	Achievement bonus;

	public BonusBuilder(Game game, Achievement bonus) {
		super();
		this.game = game;
		this.bonus = bonus;
	}

	public BonusBuilderP1 whenAchievementClassIs(Class<?> whenAchievementClassIs) {
		return new BonusBuilderP1(bonus, whenAchievementClassIs);
	}

	public class BonusBuilderP1 {
		Achievement bonus;
		Class<?> whenAchievementClassIs;

		public BonusBuilderP1(Achievement bonus, Class<?> whenAchievementClassIs) {
			super();
			this.bonus = bonus;
			this.whenAchievementClassIs = whenAchievementClassIs;
		}

		public <T extends Achievement> void when(BiFunction<T, Object, Boolean> when) {
			game.addListener(new EvaluationAchievementListener<T>(whenAchievementClassIs, when, bonus));
		}

	}
}
