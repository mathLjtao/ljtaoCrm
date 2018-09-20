<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.loginBody {
	padding: 30px 32px 23px 32px;
	width: 273px;
	background: #fff;
}

body {
	font-size: 12px Arial, Helvetica, sans-serif, 宋体 #0036a3;
	text-align: right;
}
</style>
</head>
<body>
	<div class="container">

		<div style="text-align: center">
			<div class="header-new">
				<div class="fkw-topbar-box">
					<a class="fkw-logo" target="_blank" title="点击可打开凡科网"
						href="http://www.fkw.com"></a>
					<div class="f-topbar-right">
						<a href="http://www.fkw.com/reg.html?_fromsite=false"
							target="_blank"
							style="text-decoration: none; color: #738299; font-size: 14px">免费注册</a>
						<span class="sep">&nbsp;</span> <a
							href="//www.fkw.com/alliance.html" target="_blank"
							onclick="Portal.logDog(4000023, 433)"
							style="text-decoration: none; color: #738299; font-size: 14px">招商加盟</a>

					</div>
				</div>
			</div>
		</div>
		<!-- ## END header ## -->

		<!-- ## START middle ## -->
		<div class="middle">
			<div class="content">
				<!-- ## START middle left ## -->
				<div class="left">
					<!--<div class="text">
					一站式解决自助建站、企业邮箱、互动营销需求<br>
					现在就&nbsp;<a hidefocus="true" href="//jz.fkw.com/reg.html" target="_blank">免费注册</a>&nbsp;体验更多精彩
				</div>-->
					<a id="reg-button" class="regBtn"></a>
				</div>
				<!-- ## END middle left ## -->

				<!-- ## START middle right ## -->
				<div class="right">
					<div class="loginBody">
						<div class="righttop">
							<div class="loginTab pwdLoginTab checkLoginTab"
								_loginmode="pwdLogin">密码登录</div>
							<div class="loginTab codeLoginTab" _loginmode="codeLogin">短信码登录</div>
						</div>
						<div id="log-form" class="rightmid">
							<div class="pwdLoginPanel loginPanel">
								<div class="log-input-container">
									<div class="clear" style="font-size: 0px;"></div>
									<div class="log-line log-line-hover" id="rowCacct">
										<div class="log-txt log-txt-hover">帐号/邮箱/手机号码</div>
										<input id="log-cacct" autocomplete="off" maxlength="34"
											class="log-input input2" type="text">
										<div class="logIcoNew logIcoCacct">&nbsp;</div>
									</div>
									<div class="log-line" id="rowSacct" style="display: none;">
										<div class="log-txt">员工帐号</div>
										<input id="log-sacct" autocomplete="off" maxlength="20"
											class="log-input input2" type="text">
										<div class="logIcoNew logIcoSacct">&nbsp;</div>
									</div>
									<div class="log-line" id="rowPwd">
										<div id="passwordLabel" class="log-txt">密码</div>
										<input id="log-pwd" autocomplete="new-password" maxlength="20"
											class="log-input input2" type="password"> <input
											id="showPwd" autocomplete="new-password" maxlength="20"
											class="log-input input2" type="txt">
										<div id="showPassword" class="log-showPwd loginWindowImg"
											_show="true"></div>
										<div class="logIcoNew logIcoPwd">&nbsp;</div>
									</div>

									<div id="log-valid-line" class="log-line"
										style="display: none;">
										<div class="log-txt" style="width: 116px; left: 12px;">验证码</div>
										<input id="log-valid" class="log-input input2"
											style="width: 116px; padding-left: 12px;" type="text">
										<img id="log-valid-img" title="看不清？点击换一张"> <span
											id="log-refresh-btn" title="看不清？点击换一张"></span>
									</div>

								</div>
								<div class="goin1">
									<a href="javascript:;" onclick="openPassword();">忘记密码？</a>
								</div>
								<div class="option" id="staff-login-option">
									<div class="goin">
										<input id="staff-login" class="checkBox" onclick="useSacct();"
											type="checkbox"><label class="checkItemLabel"></label><label
											for="staff-login">使用员工帐号登录</label>
									</div>
								</div>
								<div class="option">
									<div class="goin">
										<input id="auto-login" class="checkBox" type="checkbox"><label
											class="checkItemLabel"></label><label for="auto-login">两周内自动登录</label>
									</div>
								</div>
							</div>
							<div class="codeLoginPanel loginPanel">
								<div class="log-line" id="mobile">
									<div class="log-txt">手机号码</div>
									<input id="log-mobile" autocomplete="off" maxlength="34"
										class="log-input input2" type="text">
									<div class="logIcoNew logIcoMobile">&nbsp;</div>
								</div>
								<div class="log-line" id="mobileCode" style="width: 157px;">
									<div class="log-txt">短信码</div>
									<input id="log-mobileCode" style="width: 95px;"
										autocomplete="off" maxlength="4" class="log-input input2"
										type="text">
									<div class="logIcoNew logIcoMobileCode">&nbsp;</div>
								</div>
								<div class="mobileCodeBtn" disabled="disabled">获取短信码</div>
								<div style="clear: both"></div>
								<div id="codeLogin-valid-line" class="log-line"
									style="display: none;">
									<div class="log-txt" style="width: 116px; left: 12px;">验证码</div>
									<input id="codeLogin-valid" class="log-input input2"
										style="width: 116px; padding-left: 12px;" type="text">
									<img id="codeLogin-valid-img" title="看不清？点击换一张"> <span
										id="codeLogin-refresh-btn" title="看不清？点击换一张"></span>
								</div>
							</div>
							<div id="error" class="worn"></div>
							<div id="login-button" class="loginBtn">登&nbsp;&nbsp;录</div>
							<div class="clear"></div>
						</div>

					</div>

					<div class="login_otherAcct">
						<span class="login_other">其他帐号登录</span> <a class="login_WeChatI"
							href="javascript:;" onclick="bindWeChat();" title="微信登录"></a> <a
							class="login_QQI" href="javascript:;" onclick="bindQQAccount();"
							title="QQ登录"></a> <a class="registerHref"
							href="http://www.fkw.com/reg.html?_fromsite=false"
							onclick="Portal.logDog(4000118, 8);">立即注册</a>
					</div>

				</div>
				<!-- ## END middle right ## -->

				<!--<div class="clear"></div>-->

				<div class="foot">
					<div class="graw">
						Copyright <font style="font-family:" 微软雅黑',="" '黑体',="" '新宋体',=""
							'arial="" unicode="" ms'"="">© </font> 2010-2018 广州凡科互联网科技股份有限公司<br>
						<div style="padding: 5px 0 10px 0;">

							<a target="_blank" href="#"
								style="display: inline-block; text-decoration: none; height: 20px; line-height: 20px; margin-right: 5px;">
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- ## END middle ## -->
	</div>
</body>



</html>