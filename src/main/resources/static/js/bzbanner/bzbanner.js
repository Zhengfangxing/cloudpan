/*==================================
@标题：淡化版banner 带标题+描述 和 小按钮
@时间：2013.11.22
@来源：BENZI.PW
@描述:

插件使用方式:
使用前请将 CSS HTML 完整的复制。
benzi.bzBanner();

对象调用全部在js内改动
container：最外框
cols：全部内容
btns：全部小按钮
act：按钮激活样式名
pre：向前翻按钮
next：向后翻按钮


====*/
var benzi = {
	bzBanner : function(){

		//参数所有初始化（封装后将删除）
		var values = {
			container:$('.bzBanner'),
			cols:$('.bzBanner .col'),
			btns:$('.bzBanner .btn i'),
			act:'act',
			pre:$('.bzBanner .pre'),
			next:$('.bzBanner .next'),
			now:0
		}

		//淡化效果，设置所有单个对象的 zindex，以及显示和隐藏
		// col：所有内容对象
		// pre：上一个对象
		// now：当前显示的对象
		//-----------------------
		var weaken = function( pre,now ){
			var col = values.cols;
			col.css({ zIndex:1 }).eq( pre ).css({ zIndex:2 });
			col.eq( now ).css({ zIndex:3,opacity:0 }).stop(true).animate({ opacity:1 },700);
		}

		//递增计算，返回 前一个显示内容 和 当前 要显示的内容
		// now：当前已经选择的索引
		//-------------------
		var increase = function( now ){
			var pre = now ,now = pre + 1;
			if( now >= values.cols.length ) now = 0;
			return { pre:pre ,now:now };
		}

		//递减计算
		//-------------------
		var degression = function( now ){
			var pre = now ,now = pre - 1;
			if( now < 0 ) now = values.cols.length-1;
			return { pre:pre ,now:now };
		}

		//修改小按钮样式
		//---------------------
		var btnStyle = function( now ){
			if( values.btns && values.act )
				values.btns.removeClass( values.act ).eq( now ).addClass( values.act );
		}

		//小按钮事件挂接，初始化里如果有 小按钮 则执行，否则不执行
		//----------------------
		var button = function(){
			values.btns.click(function(){
				var now = $(this).index();
				if( values.now != now ){
					weaken( values.now ,now );
					btnStyle( now );
					text( now );
					values.now = now;
				}
			});
		}

		//内容切换
		// aspect：方向，0 或 无值 是后翻，1 是前翻
		//----------------------
		var change = function( aspect ){
			var val =  aspect ? degression( values.now ) : increase( values.now );
			weaken( val.pre ,val.now );
			btnStyle( val.now );
			text( val.now );
			values.now = val.now;
		}

		//左右按钮效果
		//-----------------------
		var shortcut = function(){
			values.pre.click(function(){ change(1); });
			values.next.click(function(){ change(); });
		}

		//文字切换效果，此效果很有针对性，需要样式支持
		//------------------------
		var text = function( now ){
			values.cols.find('span').css({ opacity:0 }).eq( now ).stop(true).delay(500).animate({ opacity:1 },1000);
			values.cols.find('h3').css({ opacity:0 }).eq( now ).stop(true).delay(500).animate({ opacity:1 },500);
			values.cols.find('p').css({ opacity:0 }).eq( now ).stop(true).delay(1000).animate({ opacity:1 },500);
		}

		//框架尺寸
		//-------------------------------
		$(window).resize(function(){
			values.container.height( values.cols.find('img').height() );
		}).resize();

		// 自动播放，degrees 方法获取对应参数，并且修改小按钮样式（如果有小按钮的话），然后刷新全局变量 values.now
		// time: 延时时间
		//---------------------
		var loop,play = function( time ){
			clearTimeout( loop );
			loop = setTimeout(function(){ 
				change();
				play( 3000 );
			}, time );
		}

		//暂停 和 触发自动播放
		//---------------------
		var control = function(){
			values.container.hover(function(){
				clearTimeout( loop );
			},function(){
				play( 2000 );
			});
		}

		//初始化效果，调用各个函数
		//--------------------
		var initialize = function(){
			var now = values.now;
			weaken( values.cols.length-1 ,now );
			if(values.btns ) button();
			if( values.pre && values.next ) shortcut();
			btnStyle( now );
			text( now );
			play( 4000 );
			control();
		}

		//初始化调用
		//---------------------
		initialize();

	}

}
