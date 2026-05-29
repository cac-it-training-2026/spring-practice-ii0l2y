package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p04.q01.form.BmiForm;

@Controller
public class Practice0401Controller {

	//入力画面を表示するだけ
	@RequestMapping(path = "/bmi/input", method = RequestMethod.GET)
	public String input() {
		return "practice04/01/bmi_input";
	}

	//画面から送られてきた身長と体重の値を
	//BmiFormというフォームクラスで受け取る
	@RequestMapping(path = "/bmi/result", method = RequestMethod.POST)
	public String result(BmiForm bmiForm, Model model) {

		//受け取ったデータをもとにBMIを計算
		Double weight = bmiForm.getWeight();
		Double height = bmiForm.getHeight() / 100;
		bmiForm.setBmi(weight / ((height) * (height)));

		//BmiFormオブジェクトをModelに登録することで、画面側にデータを渡す
		model.addAttribute("bmiForm", bmiForm);

		//結果表示画面へ遷移
		return "practice04/01/bmi_result";
	}

}
