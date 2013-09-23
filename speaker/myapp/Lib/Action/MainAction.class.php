<?php
class MainAction extends Action
{
	public function _initialize()
	{
		if(!isset($_SESSION['username']))
		{
			$this->redirect('Index/index');
		}
	}

	/*
	 *
	 *
	 */
	public function index()
	{
		$this->assign('username',$_SESSION['username']);
        $this->assign('school',$_SESSION['school']);
		$this->display();
	}
	/*
	 *
	 */

/**
 *
 *
 */
	public function speaker_insert()
	{
		//获取内容和时间
         $content_speaker=trim($_POST['content_speaker']);
         $time_speaker=trim($_POST['time_speaker']);
         $title_speaker=trim($_POST['title_speaker']);
         $string=trim($_GET['string']);
         if($content_speaker==''||$time_speaker=='')
         {
         	$this->error("内容或时间必填");
         }
         else{
          //找到数据库
         $school_DB=M($_SESSION['school'].$string);
          //加入数据库
          $data['content']=$content_speaker;
          $data['time']=$time_speaker;
          $data['title']=$title_speaker;
          $result=$school_DB->add($data);
          if($result)
          {
          	 $this->success("添加成功".$string);
           }else{
          	 $this->error($school_DB->getError());
           }

         }
	}
	/*
	 *
	 */

	/**
	 *
	 */
	public function speaker()
	{
		import('@.ORG.Page');
		$string=trim($_GET['string']);
         $school_DB=M($_SESSION['school'].$string);
         //获得数据总数
          $count=$school_DB->count();
          $page=new Page($count,10);
          $show=$page->show();
         $data=$school_DB->order('id desc')->limit($page->firstRow.','.$page->listRows)->select();
         $i=0;
         $this->assign('i',$i);
         $this->assign('data',$data);
         $this->assign("show",$show);
         $this->display(strtolower($string));
	}
/*
 *
 *
 */
	public function speaker_del()
	{
		$string=trim($_GET['string']);
		$school_DB=M($_SESSION['school'].$string);
		if($school_DB->delete($_GET['id']))
		{
			$this->success("删除成功");
		}
		else {
			$this->error("删除失败");
		}

	}
	/*
	 *
	 */

public function contact()
{
	$this->display();
}

}
?>