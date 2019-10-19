import React, { Component } from 'React';

class EvaluateNode extends  Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
            <div class="row">
                <div class="col-lg-12" >
                    <div class="card" style={{backgroundColor: "#EBECF1"}}>
                        <div class="testimonial-widget-one" >
                            <div class=" " >
                            <div class="item" >
                <h3>第{this.props.id}题</h3>
                <div class="testimonial-content">
                    <div class="testimonial-text" style={{height: '100px',textAlign: 'center',fontSize: '22px',lineHeight: '80px'}}>
                        <i class="fa fa-quote-left"></i>{this.props.content}<i class="fa fa-quote-right"></i>
                    </div>
                </div>

                <div class="card" style={{backgroundColor: '#F8F9FE'}}>
                    <div class="card-title">
                        <h4>你的评价</h4>
                        <div class="card-title-right-icon">
                            <input type="radio" name={"card_"+this.props.id} value="10"/>&nbsp;&nbsp;&nbsp;&nbsp;<h4>非常满意</h4>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name={"card_"+this.props.id} value="8"/>&nbsp;&nbsp;&nbsp;&nbsp;<h4>一般满意</h4>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name={"card_"+this.props.id} value="6"/>&nbsp;&nbsp;&nbsp;&nbsp;<h4>满意</h4>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name={"card_"+this.props.id} value="4"/>&nbsp;&nbsp;&nbsp;&nbsp;<h4>不满意</h4>&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>
                    </div>

                </div>
            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        );
    }
}

module.exports = EvaluateNode;