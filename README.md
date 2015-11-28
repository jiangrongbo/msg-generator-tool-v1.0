# msg-generator-tool-v1.0
为了提高日常工作效率，自己在闲暇时间写了一款工具，功能界面如下图所示：
![这里写图片描述](http://img.blog.csdn.net/20151128140330790)

从ESB文档中复制报文字段、字段类型、报文字段注释，选择生成文件路径并输入文件名：

![这里写图片描述](http://img.blog.csdn.net/20151128140631106)

输入完毕后点击生成按钮，自动生成Context=>Router报文格式：

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE segment SYSTEM "packet.dtd">
<segment>
	<xmlTag><String name="CompanyName"></String></xmlTag><!--单位名称-->
	<xmlTag><String name="DrivingLicenseId"></String></xmlTag><!--驾驶证号码-->
	<xmlTag><String name="ClientName"></String></xmlTag><!--客户名称-->
	<xmlTag><String name="DetailAddress"></String></xmlTag><!--地址明细-->
	<xmlTag><String name="DoAddress"></String></xmlTag><!--发生地-->
	<xmlTag><String name="DoneType"></String></xmlTag><!--行为代码-->
	<xmlTag><String name="DoneText"></String></xmlTag><!--行为内容-->
	<xmlTag><String name="TranDatetime"></String></xmlTag><!--处理日期时间-->
	<xmlTag><String name="UnlawfulDatetime"></String></xmlTag><!--处罚日期时间-->
	<xmlTag><String name="MotorNoteType"></String></xmlTag><!--机动车号牌类型-->
	<xmlTag><String name="MotorNoteNo"></String></xmlTag><!--机动车号牌号码-->
	<xmlTag><String name="DueFee"></String></xmlTag><!--应缴费  -->
	<xmlTag><String name="DelayAmt"></String></xmlTag><!--滞纳金-->
	<xmlTag><String name="DebtTotalAmt"></String></xmlTag><!--应收总金额 -->
</segment>

```
自动生成Router=>Esb报文格式：

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE segment SYSTEM "packet.dtd">
<segment>
	<xmlFld tagName="COMPANY_NAME" length="10"><String  name="CompanyName"></String></xmlFld><!--单位名称-->
	<xmlFld tagName="DRIVING_LICENSE_ID" length="15"><String  name="DrivingLicenseId"></String></xmlFld><!--驾驶证号码-->
	<xmlFld tagName="CLIENT_NAME" length="60"><String  name="ClientName"></String></xmlFld><!--客户名称-->
	<xmlFld tagName="DETAIL_ADDRESS" length="20"><String  name="DetailAddress"></String></xmlFld><!--地址明细-->
	<xmlFld tagName="DO_ADDRESS" length="100"><String  name="DoAddress"></String></xmlFld><!--发生地-->
	<xmlFld tagName="DONE_TYPE" length="10"><String  name="DoneType"></String></xmlFld><!--行为代码-->
	<xmlFld tagName="DONE_TEXT" length="80"><String  name="DoneText"></String></xmlFld><!--行为内容-->
	<xmlFld tagName="TRAN_DATETIME" length="64"><String  name="TranDatetime"></String></xmlFld><!--处理日期时间-->
	<xmlFld tagName="UNLAWFUL_DATETIME" length="32"><String  name="UnlawfulDatetime"></String></xmlFld><!--处罚日期时间-->
	<xmlFld tagName="MOTOR_NOTE_TYPE" length="10"><String  name="MotorNoteType"></String></xmlFld><!--机动车号牌类型-->
	<xmlFld tagName="MOTOR_NOTE_NO" length="2"><String  name="MotorNoteNo"></String></xmlFld><!--机动车号牌号码-->
	<xmlFld tagName="DUE_FEE" length="60"><String  name="DueFee"></String></xmlFld><!--应缴费  -->
	<xmlFld tagName="DELAY_AMT" length="10"><String  name="DelayAmt"></String></xmlFld><!--滞纳金-->
	<xmlFld tagName="DEBT_TOTAL_AMT" length="10"><String  name="DebtTotalAmt"></String></xmlFld><!--应收总金额 -->
</segment>

```

Esb=>Context报文格式：

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE segment SYSTEM "packet.dtd">
<segment>
	<xmlTag tagName="CompanyName"><String name="COMPANY_NAME"></String></xmlTag><!--单位名称-->
	<xmlTag tagName="DrivingLicenseId"><String name="DRIVING_LICENSE_ID"></String></xmlTag><!--驾驶证号码-->
	<xmlTag tagName="ClientName"><String name="CLIENT_NAME"></String></xmlTag><!--客户名称-->
	<xmlTag tagName="DetailAddress"><String name="DETAIL_ADDRESS"></String></xmlTag><!--地址明细-->
	<xmlTag tagName="DoAddress"><String name="DO_ADDRESS"></String></xmlTag><!--发生地-->
	<xmlTag tagName="DoneType"><String name="DONE_TYPE"></String></xmlTag><!--行为代码-->
	<xmlTag tagName="DoneText"><String name="DONE_TEXT"></String></xmlTag><!--行为内容-->
	<xmlTag tagName="TranDatetime"><String name="TRAN_DATETIME"></String></xmlTag><!--处理日期时间-->
	<xmlTag tagName="UnlawfulDatetime"><String name="UNLAWFUL_DATETIME"></String></xmlTag><!--处罚日期时间-->
	<xmlTag tagName="MotorNoteType"><String name="MOTOR_NOTE_TYPE"></String></xmlTag><!--机动车号牌类型-->
	<xmlTag tagName="MotorNoteNo"><String name="MOTOR_NOTE_NO"></String></xmlTag><!--机动车号牌号码-->
	<xmlTag tagName="DueFee"><String name="DUE_FEE"></String></xmlTag><!--应缴费  -->
	<xmlTag tagName="DelayAmt"><String name="DELAY_AMT"></String></xmlTag><!--滞纳金-->
	<xmlTag tagName="DebtTotalAmt"><String name="DEBT_TOTAL_AMT"></String></xmlTag><!--应收总金额 -->
</segment>
```
项目结构如下图所示，总代码不超过1w行，源码已分享到Github:https://github.com/rongbo-j/msg-generator-tool-v1.0

![这里写图片描述](http://img.blog.csdn.net/20151128141341868)

