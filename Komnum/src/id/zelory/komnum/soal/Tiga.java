package id.zelory.komnum.soal;

public class Tiga
{
	public static final String text = "x^2 + x";

	public static String hitungBagiDua(Double nim, Double error)
	{
		String jawaban = "";
		Double tmp = 0.0, x = 0.0, min, mid, max;

		while (tmp < nim)
		{
			tmp = x * x + x;
			x++;
		}

		min = x - 2;
		max = x - 1;
		mid = (min + max) / 2.0;
		jawaban += "<br/>* f(x) = x^2 + x - " + nim + "<br/>";
		tmp = min * min + min;
		jawaban += "<br/>Tebakan pertama = " + min;
		jawaban += "<br/>" + "f(" + min + ") = " + min + "^2 + " + min + " - "
				+ nim + "<br/>";
		jawaban += "= " + min * min + " + " + min + " - " + nim + "<br/>";
		jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim) + "<br/>";

		tmp = max * max + max;
		jawaban += "<br/>Tebakan kedua = " + max;
		jawaban += "<br/>" + "f(" + max + ") = " + max + "^2 + " + max + " - "
				+ nim + "<br/>";
		jawaban += "= " + max * max + " + " + max + " - " + nim + "<br/>";
		jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim)
				+ "<br/><br/>";

		int i = 1;
		while (true)
		{
			tmp = mid * mid + mid;
			jawaban += "<br/>* Iterasi ke " + i;
			jawaban += ".<br/>=> Interval dari " + min + " sampai dengan "
					+ max + ", titik tengah adalah " + mid + ".<br/>";
			jawaban += "f(" + mid + ") = " + mid + "^2 + " + mid + " - " + nim
					+ "<br/>";
			jawaban += "= " + mid * mid + " + " + mid + " - " + nim + "<br/>";
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
			tmp = x * x + x;
			x++;
		}

		x--;
		jawaban += "<br/>* f(x) = x^2 + x - " + nim + "<br/>";
		jawaban += "* f'(x) = 2x + 1 <br/>";
		jawaban += "<br/>Tebakan awal adalah " + x + "<br/>";
		int i = 0;
		while (true)
		{
			fx = x * x + x - nim;
			fx2 = (2 * x) + 1;
			tmp = x - (fx / fx2);
			jawaban += "==> x" + i + " = " + x + "<br/>";
			jawaban += "f(" + x + ") = " + x + "^2 + " + x + " - " + nim
					+ "<br/>";
			jawaban += "= " + x * x + " + " + x + " - " + nim + "<br/>";
			jawaban += "= " + (x * x + x) + " - " + nim + " = " + fx
					+ "<br/><br/>";

			if (Math.abs(fx) <= error)
				break;

			i++;
			jawaban += "x" + i + " = " + x + " - (" + x + "^2 + " + x + " - "
					+ nim + ") / (2 * " + x + " + 1)<br/>";
			jawaban += "= " + x + " - (" + x * x + " + " + x + " - " + nim
					+ ") / (" + 2 * x + " + " + "1)<br/>";
			jawaban += "= " + x + " - (" + fx + " / " + fx2 + ")<br/>";
			jawaban += "= " + x + " - " + fx / fx2 + " = " + tmp + "<br/><br/>";

			x = tmp;

		}
		jawaban += "<br/>Jadi nilai x yang memenuhi adalah : " + x;
		return jawaban;
	}
}
