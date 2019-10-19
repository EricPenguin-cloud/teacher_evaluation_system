import React, { Component } from 'React';
import echarts from 'echarts';
import axios from '../api/axios_api.jsx'
class DataView extends Component{
    constructor(props){
        super(props);
    }
    async componentDidMount(){
        console.log(await axios._selectCountT());
        console.log(await axios._selectAnswerT());
        console.log(await axios._selectCountS());
        console.log(await axios._selectAnswerS());
        
        let cout_t = await axios._selectCountT();
        let answer_t = await axios._selectAnswerT();
        let cout_s = await axios._selectCountS();
        let answer_s = await axios._selectAnswerS();
        
        
        let myChart_1 = echarts.init(document.getElementById('main1'));

                // 指定图表的配置项和数据
                let option_1 = {
                    title: {
                        text: '学生评教师结果统计'
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    legend: {
                        data: ['测评结果']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'value',
                        boundaryGap: [0, 0.1]
                    },
                    yAxis: {
                        type: 'category',
                        data: ['10','20','30','40','50','60','70','80','90','100(分)']
                    },
                    series: [
                        {
                            name: '人数',
                            type: 'bar',
                            data: cout_s,
                        }
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart_1.setOption(option_1);

                var myChart_2 = echarts.init(document.getElementById('main2'));
            
                let option_2 = {
                    title: {
                        text: '学生对教师评价情况',
                        left: 'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        // orient: 'vertical',
                        // top: 'middle',
                        bottom: 10,
                        left: 'center',
                        data: ['非常满意', '一般满意','满意','不满意']
                    },
                    series : [
                        {
                            type: 'pie',
                            radius : '65%',
                            center: ['50%', '50%'],
                            selectedMode: 'single',
                            data:[
                                {value:answer_s[0], name: '非常满意'},
                                {value:answer_s[1], name: '一般满意'},
                                {value:answer_s[2], name: '满意'},
                                {value:answer_s[3],name: '不满意'}
                            ],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
            // 使用刚指定的配置项和数据显示图表。
            myChart_2.setOption(option_2 );

            
            let myChart_3 = echarts.init(document.getElementById('main3'));

            // 指定图表的配置项和数据
            let option_3 = {
                title: {
                    text: '教师评教师结果统计'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['测评结果']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value',
                    boundaryGap: [0, 0.1]
                },
                yAxis: {
                    type: 'category',
                    data: ['10','20','30','40','50','60','70','80','90','100(分)']
                },
                series: [
                    {
                        name: '人数',
                        type: 'bar',
                        data: cout_t,
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart_3.setOption(option_3);

            var myChart_4 = echarts.init(document.getElementById('main4'));
            
            let option_4 = {
                title: {
                    text: '教师对教师评价情况',
                    left: 'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    // orient: 'vertical',
                    // top: 'middle',
                    bottom: 10,
                    left: 'center',
                    data: ['非常满意', '一般满意','满意','不满意']
                },
                series : [
                    {
                        type: 'pie',
                        radius : '65%',
                        center: ['50%', '50%'],
                        selectedMode: 'single',
                        data:[
                            {value:answer_t[0], name: '非常满意'},
                            {value:answer_t[1], name: '一般满意'},
                            {value:answer_t[2], name: '满意'},
                            {value:answer_t[3],name: '不满意'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
        // 使用刚指定的配置项和数据显示图表。
        myChart_4.setOption(option_4 );
    }
    render(){
    return(<div>
        <div id="main1" style={{width: '600px',height:'400px',float:'left',marginTop:'40px'}}></div>
        <div id="main2" style={{width: '600px',height:'400px',float:'left',marginTop:'40px'}}></div>
        <div id="main3" style={{width: '600px',height:'400px',float:'left',marginTop:'40px'}}></div>
        <div id="main4" style={{width: '600px',height:'400px',float:'left',marginTop:'40px'}}></div></div>)
    }

}
module.exports = DataView;