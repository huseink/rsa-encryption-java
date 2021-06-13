import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSA {
	private BigInteger p, q, n, phi, e, d;
	private BigInteger msg, enc, dec;
	
	public RSA() {
	}

	public RSA(BigInteger p, BigInteger q, BigInteger e) {
		this.p = p;
		this.q = q;
		this.e = e;
	}

	public BigInteger getP() {
		return p;
	}

	public void setP(BigInteger p) {
		this.p = p;
	}

	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger q) {
		this.q = q;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}

	public BigInteger getPhi() {
		return phi;
	}

	public void setPhi(BigInteger phi) {
		this.phi = phi;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}

	public BigInteger getMsg() {
		return msg;
	}

	public void setMsg(BigInteger msg) {
		this.msg = msg;
	}

	public BigInteger getEnc() {
		return enc;
	}

	public void setEnc(BigInteger enc) {
		this.enc = enc;
	}

	public BigInteger getDec() {
		return dec;
	}

	public void setDec(BigInteger dec) {
		this.dec = dec;
	}

	public BigInteger calculateN() {
		n = p.multiply(q);
		return n;
	}

	public BigInteger calculatePhi() {
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		return phi;
	}

	public List<BigInteger> possibleExponentValues() {
		final int maxSize = 100000;
		List<BigInteger> invertibles = new ArrayList<BigInteger>();
		BigInteger end = n.subtract(BigInteger.ONE);
		for (BigInteger i = new BigInteger("5"); i.compareTo(end) < 0; i = i.add(BigInteger.ONE)) {
			if (i.gcd(phi).equals(BigInteger.ONE)) {
				invertibles.add(i);
				if (invertibles.size() == maxSize)
					break;
			}
		}
		return invertibles;
	}

	public BigInteger generateKeys() {
		d = e.modInverse(phi);
		return d;
	}

	public BigInteger encrpytMessage(BigInteger msg) {
		enc = msg.modPow(e, n);
		return enc;
	}

	public BigInteger decrpytMessage() {
		dec = enc.modPow(d, n);
		return dec;
	}
}
