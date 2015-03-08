package id.zelory.komnum;

import id.zelory.komnum.constant.HTMLContent;
import id.zelory.komnum.soal.Dua;
import id.zelory.komnum.soal.Empat;
import id.zelory.komnum.soal.Lima;
import id.zelory.komnum.soal.Satu;
import id.zelory.komnum.soal.Tiga;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class KomnumServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException
	{
		resp.setContentType("text/html");

		int pers = 0, metode = 0;
		Double nim = null, error = null;

		try
		{
			pers = Integer.parseInt(req.getParameter("pers"));
			metode = Integer.parseInt(req.getParameter("metode"));
			nim = Double.parseDouble(req.getParameter("nim"));
			error = Double.parseDouble(req.getParameter("error"));
		}
		catch (Exception e)
		{
			resp.getWriter().println(HTMLContent.header + HTMLContent.footer);
		}

		if (pers == 0 || metode == 0 || nim == null || error == null)
		{

		}
		else
		{
			String jawaban = null, metodeText = null, soal = null;

			if (metode == 1)
				metodeText = "bagi dua";
			else
				metodeText = "Newton";

			if (pers == 1 && metode == 1)
			{
				jawaban = Satu.hitungBagiDua(nim, error);
				soal = Satu.text;
			}
			else if (pers == 1 && metode == 2)
			{
				jawaban = Satu.hitungNewton(nim, error);
				soal = Satu.text;
			}
			else if (pers == 2 && metode == 1)
			{
				jawaban = Dua.hitungBagiDua(nim, error);
				soal = Dua.text;
			}
			else if (pers == 2 && metode == 2)
			{
				jawaban = Dua.hitungNewton(nim, error);
				soal = Dua.text;
			}
			else if (pers == 3 && metode == 1)
			{
				jawaban = Tiga.hitungBagiDua(nim, error);
				soal = Tiga.text;
			}
			else if (pers == 3 && metode == 2)
			{
				jawaban = Tiga.hitungNewton(nim, error);
				soal = Tiga.text;
			}
			else if (pers == 4 && metode == 1)
			{
				jawaban = Empat.hitungBagiDua(nim, error);
				soal = Empat.text;
			}
			else if (pers == 4 && metode == 2)
			{
				jawaban = Empat.hitungNewton(nim, error);
				soal = Empat.text;
			}
			else if (pers == 5 && metode == 1)
			{
				jawaban = Lima.hitungBagiDua(nim, error);
				soal = Lima.text;
			}
			else if (pers == 5 && metode == 2)
			{
				jawaban = Lima.hitungNewton(nim, error);
				soal = Lima.text;
			}
			else
			{
				jawaban = "Soal sedang dalam pengerjaan";
				soal = "Soal belum tersedia.";
			}

			resp.getWriter().println(
					HTMLContent.header + HTMLContent.headerHasil + "<p>Soal : "
							+ soal + " = " + nim + " dengan ketelitian "
							+ error + " menggunakan metode " + metodeText
							+ "</p><p>" + jawaban + "</p>"
							+ HTMLContent.footerHasil + HTMLContent.footer);
		}
	}
}
