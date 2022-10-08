var getVCode = function () {
    $.ajax({
        url: "/captcha?random=" + new Date().getTime(),
        dataType: 'json',
        success: function (result) {
            if (result && result.errCode === 200)
                $("#validatorCodeOfLogin").attr("src", result.data)
        }
    });
};

function loginBySms() {
    let username = $("#id-login-mobile").val();
    let loginSms = $("#id-login-sms-code").val();
    if (username == null || username === "") {
        Tools.showError("手机号不能为空")
        return
    }

    if (loginSms == null || loginSms === "") {
        Tools.showError("短信验证码不能为空")
        return
    }

    Tools.ajaxPost("/auth/loginBySms", {
        username: username, loginSms: loginSms
    }, function (res) {
        if (res.errCode === 200) {
            getVCode()
            $("#captcha").val("");
            Tools.showError(res.errMessage)
        } else {
            if (goPage) {
                window.location.href = goPage
            } else {
                window.location.href = "/index"
            }
        }
    })
}

function login() {
    let username = $("#id-login-username").val();
    let password = $("#id-login-password").val();
    var captcha = $("#captcha").val();

    if (username == null || username === "") {
        Tools.showError("用户名不能为空")
        return
    }

    if (password == null || password === "") {
        Tools.showError("密码不能为空")
        return
    }

    if ($.trim(captcha) === "") {
        Tools.showError("验证码不能为空")
        return;
    }

    Tools.ajaxPost("/auth/login", {
        username: username, password: md5(password), captcha: captcha
    }, function (res) {
        if (res.errCode === 200) {
            getVCode()
            $("#captcha").val("");
            Tools.showError(res.errMsg)
        } else {
            if (goPage) {
                window.location.href = goPage
            } else {
                window.location.href = "/index"
            }
        }
    })
}

$(document).keyup(function (e) {
    var key = e.which;
    if (key === 13) {
        login()
    }
});

var goPage = null;
var viewCompanyFile = false;
$(function () {
    var url = document.location.toString();
    var arrUrl = url.split("?");
    if (arrUrl[1]) {
        goPage = arrUrl[1].substring(7);
        if (goPage.startsWith("/view/viewFileList/")) {
            $(".sms-login").removeClass("d-none")
            $(".password-login").addClass("d-none")
        } else {
            $(".sms-login").addClass("d-none")
            $(".password-login").removeClass("d-none")
        }
    } else {
        $(".sms-login").addClass("d-none")
        $(".password-login").removeClass("d-none")
    }
    getVCode();
    Tools.click("id-button-login", function () {
        login()
    });
    Tools.click("id-button-sms-login", function () {
        loginBySms()
    })
    Tools.click("id-button-sms", function () {

        let username = $("#id-login-mobile").val();
        if (username == null || username === "") {
            Tools.showError("手机号不能为空")
            return
        }

        Tools.ajaxPost("/auth/getSms?phone=" + username, null, function (res) {
            if (res.errCode === 200) {
                Tools.showError(res.errMessage)
            } else {
                Tools.showInfo("短信验证码获取成功")
                var time = 60;
                setInterval (function () {
                    $("#id-button-sms").text(time + "s后重新获取")
                    time--;
                }, 1000);
            }
        })
    })
})