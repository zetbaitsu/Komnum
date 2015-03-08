package id.zelory.komnum.soal;

public class Empat
{
	public static final String text = "x^3 + x^2 + x";

	public static String hitungBagiDua(Double nim, Double error)
	{
		String jawaban = "";
		Double tmp = 0.0, x = 0.0, min, mid, max;

		while (tmp < nim)
		{
			tmp = Math.pow(x, 3) + Math.pow(x, 2) + x;
			x++;
		}

		min = x - 2;
		max = x - 1;
		mid = (min + max) / 2.0;
		jawaban += "<br/>* f(x) = x^2 + x^2 + x - " + nim + "<br/>";
		tmp = Math.pow(min, 3) + Math.pow(min, 2) + min;
		jawaban += "<br/>Tebakan pertama = " + min;
		jawaban += "<br/>" + "f(" + min + ") = " + min + "^3 + " + min
				+ "^2 + " + min + " - " + nim + "<br/>";
		jawaban += "= " + Math.pow(min, 3) + " + " + Math.pow(min, 2) + " + "
				+ min + " - " + nim + "<br/>";
		jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim) + "<br/>";

		tmp = Math.pow(max, 3) + Math.pow(max, 2) + max;
		jawaban += "<br/>Tebakan kedua = " + max;
		jawaban += "<br/>" + "f(" + max + ") = " + max + "^3 + " + max
				+ "^2 + " + max + " - " + nim + "<br/>";
		jawaban += "= " + Math.pow(max, 3) + " + " + Math.pow(max, 2) + " + "
				+ max + " - " + nim + "<br/>";
		jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim)
				+ "<br/><br/>";

		int i = 1;
		while (true)
		{
			tmp = Math.pow(mid, 3) + Math.pow(mid, 2) + mid;
			jawaban += "<br/>* Iterasi ke " + i;
			jawaban += ".<br/>=> Interval dari " + min + " sampai dengan "
					+ max + ", titik tengah adalah " + mid + ".<br/>";
			jawaban += "f(" + mid + ") = " + mid + "^3 + " + mid + "^2 + "
					+ mid + " - " + nim + "<br/>";
			jawaban += "= " + Math.pow(mid, 3) + " + " + Math.pow(mid, 2)
					+ " + " + mid + " - " + nim + "<br/>";
			jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim)
					+ "<br/><br/>";

			if (Math.abs(tmp - nim) <= error)
				break;

			if (tmp > nim)
			{
				max = mid;
			}
			else
			{
				min = mid;
			}

			mid = (min + max) / 2.0;
			i++;
		}
		jawaban += "<br/>Jadi nilai x yang memenuhi adalah : " + mid;
		return jawaban;
	}

	public static String hitungNewton(Double nim, Double error)
	{
		String jawaban = "";
		Double tmp = 0.0, x = 0.0, fx, fx2;

		while (tmp < nim)
		{
			tmp = Math.pow(x, 3) + Math.pow(x, 2) + x;
			x++;
		}

		x--;
		jawaban += "<br/>* f(x) = x^3 + x^2 + x - " + nim + "<br/>";
		jawaban += "* f'(x) = 3x^2 + 2x + 1 <br/>";
		jawaban += "<br/>Tebakan awal adalah " + x + "<br/>";
		int i = 0;
		while (true)
		{
			fx = Math.pow(x, 3) + Math.pow(x, 2) + x - nim;
			fx2 = (3 * Math.pow(x, 2)) + (2 * x) + 1;
			tmp = x - (fx / fx2);
			jawaban += "==> x" + i + " = " + x + "<br/>";
			jawaban += "f(" + x + ") = " + x + "^3 + " + x + "^2 + " + x
					+ " - " + nim + "<br/>";
			jawaban += "= " + Math.pow(x, 3) + " + " + Math.pow(x, 2) + " + "
					+ x + " - " + nim + "<br/>";
			jawaban += "= " + (Math.pow(x, 3) + Math.pow(x, 2) + x) + " - "
					+ nim + " = " + fx + "<br/><br/>";

			if (Math.abs(fx) <= error)
				break;

			i++;
			jawaban += "x" + i + " = " + x + " - (" + x + "^3 + " + x + "^2"
					+ x + " - " + nim + ") / (3 * " + x + "^2 + 2 * " + x
					+ " + 1)<br/>";
			jawaban += "= " + x + " - (" + Math.pow(x, 3) + " + "
					+ Math.pow(x, 2) + " + " + x + " - " + nim + ") / (" + 3
					* Math.pow(x, 2) + " + " + (2 * x + 1) + ")<br/>";
			jawaban += "= " + x + " - (" + fx + " / " + fx2 + ")<br/>";
			jawaban += "= " + x + " - " + fx / fx2 + " = " + tmp + "<br/><br/>";

			x = tmp;

		}
		jawaban += "<br/>Jadi nilai x yang memenuhi adalah : " + x;
		return jawaban;
	}
}
