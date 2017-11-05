function callTollTip(input) {
	$(input).parent().tooltip({
		trigger: 'manual',
        title: 'Por favor, preencha o campo.',
        template: '<div class="tooltip" role="tooltip">'+
        		  	'<div class="tooltip-arrow fail">'+
        		  '</div>'+
        		  '<div class="tooltip-inner fail"></div></div>',
        placement: 'top'
	}).tooltip('show');	
}
function togglePessoa() {
	$('#block_cpf').toggleClass('hidden');
	$('#block_cnpj').toggleClass('hidden');
}

function validateUser() {
	$('#form_add_user').submit(function(){
		var inputNome = $('#user_name');
		var inputCpf = $('#user_cpf');
		var inputCnpj = $('#user_cnpj');
		var inputEmail = $('#user_email');
		var inputTel = $('#user_tel');
		var inputNasc = $('#user_nasc');
		
		var errors = [];
		if ($(inputNome).val() == "") {
			callTollTip(inputNome);
			
			errors.push(1);
			$(inputNome).on('keyup', function() {
				$(inputNome).parent().tooltip('hide');
			})
		}
		if ($('#block_cnpj').hasClass('hidden')) {
			if ($(inputCpf).val() == "") {
				callTollTip(inputCpf);

				errors.push(1);
				$(inputCpf).on('keyup', function() {
					$(inputCpf).parent().tooltip('hide');
				})
			}	
		}
		if ($('#block_cpf').hasClass('hidden')) {
			if ($(inputCnpj).val() == "") {
				callTollTip(inputCnpj);		
				
				errors.push(1);
				$(inputCnpj).on('keyup', function() {
					$(inputCnpj).parent().tooltip('hide');
				})
			}	
		}
		if ($(inputEmail).val() == "") {
			callTollTip(inputEmail);		
			
			errors.push(1);
			$(inputEmail).on('keyup', function() {
				$(inputEmail).parent().tooltip('hide');
			})
		}
		if ($(inputTel).val() == "") {
			callTollTip(inputTel);		
			
			errors.push(1);
			$(inputTel).on('keyup', function() {
				$(inputTel).parent().tooltip('hide');
			})
		}

		if ($(inputNasc).val() == "") {
			callTollTip(inputNasc);		
			
			errors.push(1);
			$(inputNasc).on('keyup', function() {
				$(inputNasc).parent().tooltip('hide');
			})
		}
		if (errors.length > 0)
			return false;
		return true;	
	});
}

function validatePayment() {
	$('#form_add_payment').submit(function(){
		var inputPayNumber = $('#pay_number');
		var inputPayDate = $('#pay_date');
		var inputPayCvv = $('#pay_ccv');

		
		var errors = [];
		
		if($('#dadosCartao').css("display") == "block"){
			if ($(inputPayNumber).val() == "") {
				callTollTip(inputPayNumber);
				
				errors.push(1);
				$(inputPayNumber).on('keyup', function() {
					$(inputPayNumber).parent().tooltip('hide');
				})
			}
			if ($(inputPayDate).val() == "") {
				callTollTip(inputPayDate);
				
				errors.push(1);
				$(inputPayDate).on('keyup', function() {
					$(inputPayDate).parent().tooltip('hide');
				})
			}
			if ($(inputPayCvv).val() == "") {
				callTollTip(inputPayCvv);
				
				errors.push(1);
				$(inputPayCvv).on('keyup', function() {
					$(inputPayCvv).parent().tooltip('hide');
				})
			}
		}
		
		if (errors.length > 0)
			return false;
		return true;	
	});
}

$(document).ready(function(){
	$('#user_cpf').mask('000.000.000-00');
	$('#user_cnpj').mask('99.999.999/9999-99');
	$('#user_nasc').mask('99/99/9999');
	
	validateUser();
	validatePayment();
	
});
