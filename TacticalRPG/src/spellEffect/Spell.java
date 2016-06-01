package spellEffect;

import gameObject.Character;
import gameObject.Tile;

import java.util.List;

import spellEffect.spell.Charge;
import spellEffect.spell.DivineShield;
import spellEffect.spell.DodgeBoost;
import spellEffect.spell.FireBall;
import spellEffect.spell.LongAttack;
import spellEffect.spell.MagicBoost;
import spellEffect.spell.Meteore;
import spellEffect.spell.MultiArrow;
import spellEffect.spell.MultiAttack;
import spellEffect.spell.PowerHeal;
import spellEffect.spell.RangeBoost;
import spellEffect.spell.Reanimation;
import spellEffect.spell.Root;
import spellEffect.spell.Sprint;
import spellEffect.spell.Throws;
import spellEffect.spell.UnstopableAttack;
import spellEffect.spell.ZoneHeal;

public abstract class Spell {
	public enum TypeSpell{CHARGE, DIVINESHIELD, DODGEBOOST, FIREBALL, LONGATTACK, MAGICBOOST, METEORE, MULTIARROW, MULTIATTACK, POWERHEAL, RANGEBOOST, REANIMATION, ROOT, SPRINT, THROWS, UNSTOPABLEATTACK, ZONEHEAL}
	protected int manaCost;
	protected int damage;
	protected int range;
	protected TypeSpell typeSpell;
	
	public Spell(int cost, int damage, int range, TypeSpell typeSpell){
		this.manaCost = cost;
		this.damage =damage;
		this.range = range;
		this.typeSpell = typeSpell;
	}

	public int getManaCost() {
		return manaCost;
	}
	
	public double getDamage() {
		return damage;
	}

	public TypeSpell getTypeSpell() {
		return typeSpell;
	}
	
	public void whichSpell(List<Character> listCharacter, Character character, spellEffect.Spell spell, Tile tileA, Tile tileB){
		switch(spell.typeSpell){
		case CHARGE:
			((Charge) spell).charge(listCharacter);
			break;
		case DIVINESHIELD:
			((DivineShield) spell).shield(character);
			break;
		case DODGEBOOST:
			((DodgeBoost) spell).dodge(character);
			break;
		case FIREBALL:
			((FireBall) spell).FireDamage(listCharacter);
			break;
		case LONGATTACK:
			((LongAttack) spell).LongDamage(tileA.getX(), tileA.getY(), tileB.getX(), tileB.getY(), listCharacter);
			break;
		case MAGICBOOST:
			((MagicBoost) spell).magic(character);
			break;
		case METEORE:
			((Meteore) spell).meteore(listCharacter);
			break;
		case MULTIARROW:
			((MultiArrow) spell).multi(listCharacter);
			break;
		case MULTIATTACK:
			((MultiAttack) spell).multiA(listCharacter);
			break;
		case POWERHEAL:
			((PowerHeal) spell).pHeal(listCharacter);
			break;
		case RANGEBOOST:
			((RangeBoost) spell).rBoost(character);
			break;
		case REANIMATION:
			((Reanimation) spell).rea(character);
			break;
		case ROOT:
			((Root) spell).root(listCharacter);
			break;
		case SPRINT:
			((Sprint) spell).sprint(character);
			break;
		case THROWS:
			((Throws) spell).throwAttack(listCharacter);
			break;
		case UNSTOPABLEATTACK:
			((UnstopableAttack) spell).unStop(listCharacter);
			break;
		case ZONEHEAL:
			((ZoneHeal) spell).zoneHeal(listCharacter);
			break;
		}
		
			
	}
}
