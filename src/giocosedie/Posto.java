package giocosedie;

/**
 * classe Posto
 * comunica lo stato dei posti disponibili
 */
class Posto

{
	private boolean occupato;

	public Posto()

	{
		occupato = false;
	}
/**
 * stabilisce lo stato di un posto (libero od occupato)
 * @return TRUE se libero FALSE se occupato
 */
	public synchronized boolean libero() {
		return (!occupato);
	}
/**
 * verifica se una sedia è stata occupata o meno
 * @return TRUE se la sedia è stata occupata FALSE se la sedia non è stata occupata
 */
	public synchronized boolean occupa() {
		if (occupato)
			return false;
		else
			return occupato = true;
	}
}