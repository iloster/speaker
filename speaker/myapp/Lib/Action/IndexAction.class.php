<?php
// 本类由系统自动生成，仅供测试用途
class IndexAction extends Action {
	public function _initialize()
	{
		if(isset($_SESSION['username']))
		{
			$this->redirect('Main/index');
		}
	}
    public function index(){

	 $this->display();
    }

    /**
     * 登录验证函数
     *
     */
    public function CheckLogin()
    {
    	if(!IS_POST) halt("页面不存在");
    	//获取输入的用户名和密码
    	$username=trim($_POST['username']);
    	$password=trim($_POST['password']);
    	$user=M('User1');
    	$condition['username']=$username;
    	$condition['password']=$password;
    	//与数据库中的信息进行比对
    	$tag=$user->where($condition)->find();
    	//$tag=$user->where('id=1')->select();
    	$school=$user->where($condtion)->getField('school');

    	if($tag)
    	{

    		//验证成功后跳转至操作页面
    		//$this->success("登录成功","http://www.baidu.com");
          //var_dump($username,$password);
    		$this->success("登录成功","Main/index");
    	}
    	else
    	{
    		//验证失败
    		$this->error("用户名或者密码错误");
    	}
        session("school",$school);
    	session("username",$username);

    }
}
