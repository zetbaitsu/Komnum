package id.zelory.komnum.soal;

public class Dua
{
	public static final String text = "x ln(x)";

	public static String hitungBagiDua(Double nim, Double error)
	{
		String jawaban = "";
		Double tmp = 0.0, x = 1.0, min, mid, max;

		while (tmp < nim)
		{
			tmp = x * Math.log(x);
			x++;
		}

		min = x - 2;
		max = x - 1;
		mid = (min + max) / 2.0;

		jawaban += "<br/>* f(x) = x ln(x) - " + nim + "<br/>";
		tmp = min * Math.log(min);
		jawaban += "<br/>Tebakan pertama = " + min;
		jawaban += "<br/>" + "f(" + min + ") = " + min + " * ln(" + min
				+ ") - " + nim + "<br/>";
		jawaban += "= " + min + " * " + Math.log(min) + " - " + nim + "<br/>";
		jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim) + "<br/>";

		tmp = max * Math.log(max);
		jawaban += "<br/>Tebakan kedua = " + max;
		jawaban += "<br/>" + "f(" + max + ") = " + max + " * ln(" + max
				+ ") - " + nim + "<br/>";
		jawaban += "= " + max + " * " + Math.log(max) + " - " + nim + "<br/>";
		jawaban += "= " + tmp + " - " + nim + " = " + (tmp - nim)
				+ "<br/><br/>";

		int i = 1;
		while (true)
		{
			tmp = mid * Math.log(mid);
			jawaban += "<br/>* Iterasi ke " + i;
			jawaban += ".<br/>=> Interval dari " + min + " sampai dengan "
					+ max + ", titik tengah adalah " + mid + ".<br/>";
			jawaban += "f(" + mid + ") = " + mid + " * ln(" + mid + ") - "
					+ nim + "<br/>";
			jawaban += "= " + mid + " * " + Math.log(mid) + " - " + nim
					+ "<br/>";
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
		Double tmp = 0.0, x = 1.0, fx, fx2;

		while (tmp < nim)
		{
			tmp = x * Math.log(x);
			x++;
		}

		x--;
		jawaban += "<br/>* f(x) = x ln(x) - " + nim + "<br/>";
		jawaban += "* f'(x) = ln(x) + 1 <br/>";
		jawaban += "<br/>Tebakan awal adalah " + x + "<br/>";
		int i = 0;
		while (true)
		{
			fx = x * Math.log(x) - nim;
			fx2 = Math.log(x) + 1;
			tmp = x - (fx / fx2);
			jawaban += "==> x" + i + " = " + x + "<br/>";
			jawaban += "f(" + x + ") = " + x + " * ln(" + x + ") - " + nim
					+ "<br/>";
			jawaban += "= " + x + " * " + Math.log(x) + " - " + nim + "<br/>";
			jawaban += "= " + x * Math.log(x) + " - " + nim + " = " + fx
					+ "<br/><br/>";

			if (Math.abs(fx) <= error)
				break;

			i++;
			jawaban += "x" + i + " = " + x + " - (" + x + " * ln(" + x + ") - "
					+ nim + ") / (ln(" + x + ") + 1)<br/>";
			jawaban += "= " + x + " - (" + x + " * " + Math.log(x) + " - "
					+ nim + ") / (" + Math.log(x) + " + 1)<br/>";
			jawaban += "= " + x + " - (" + fx + " / " + fx2 + ")<br/>";
			jawaban += "= " + x + " - " + fx / fx2 + " = " + tmp + "<br/><br/>";

			x = tmp;

		}
		jawaban += "<br/>Jadi nilai x yang memenuhi adalah : " + x;
		return jawaban;
	}
}
