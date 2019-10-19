const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

module.exports = {
  entry: {
    admin_login:'./react_js/admin_login.jsx',
    admin_index:'./react_js/admin_index.jsx',
    inform_stu:'./react_js/inform_stu.jsx',
    inform_tea:'./react_js/inform_tea.jsx',
    import_stu:'./react_js/import_stu.jsx',
    import_tea:'./react_js/import_tea.jsx',
    stu_evaluate:'./react_js/stu_evaluate.jsx',
    stu_login:'./react_js/stu_login.jsx',
    stu_index:'./react_js/stu_index.jsx',
    stu_evaluation:'./react_js/stu_evaluation.jsx',
    student:'./react_js/student.jsx',
    stu_update_pw:'./react_js/stu_update_pw.jsx',
    stu_view_result:'./react_js/stu_view_result.jsx',
    t_login:'./react_js/t_login.jsx',
    t_index:'./react_js/t_index.jsx',
    t_evaluation:'./react_js/t_evaluation.jsx',
    t_my_evaluation:'./react_js/t_my_evaluation.jsx',
    t_evaluate:'./react_js/t_evaluate.jsx',
    t_my_result:'./react_js/t_my_result.jsx',
    t_update_pw:'./react_js/t_update_pw.jsx',
    t_view_result:'./react_js/t_view_result.jsx',
    teacher:'./react_js/teacher.jsx',
    //public
    stu_inform:'./react_js/public/stu_inform.jsx',
    tea_inform:'./react_js/public/tea_inform.jsx',
    admin_inform:'./react_js/public/admin_inform.jsx',
    admin_listener:'./react_js/public/admin_listener.jsx'
  },
  devtool: 'inline-source-map',
  output: {
    filename: '[name].bundle.js',
    path: path.resolve(__dirname, 'dist')
  },
  plugins: [
         new HtmlWebpackPlugin({
          template: './administer/admin-login.html',
          filename: '../page/administer/admin-login.html',
          chunks: ['admin_login']
         }),
         new HtmlWebpackPlugin({
          template: './administer/admin-index.html',
          filename: '../page/administer/admin-index.html',
          chunks: ['admin_listener','admin_index','admin_inform']
         }),
         new HtmlWebpackPlugin({
          template: './administer/inform-stu.html',
          filename: '../page/administer/inform-stu.html',
          chunks: ['admin_listener','inform_stu','admin_inform']
         }),
         new HtmlWebpackPlugin({
          template: './administer/inform-tea.html',
          filename: '../page/administer/inform-tea.html',
          chunks: ['admin_listener','inform_tea','admin_inform']
         }),
         new HtmlWebpackPlugin({
          template: './administer/import-tea.html',
          filename: '../page/administer/import-tea.html',
          chunks: ['admin_listener','import_tea','admin_inform']
         }),
         new HtmlWebpackPlugin({
          template: './administer/import-stu.html',
          filename: '../page/administer/import-stu.html',
          chunks: ['admin_listener','import_stu','admin_inform']
         }),
         new HtmlWebpackPlugin({
          template: './student/stu-evaluate.html',
          filename: '../page/student/stu-evaluate.html',
          chunks: ['stu_evaluate','stu_inform']
         }),
         new HtmlWebpackPlugin({
          template: './student/stu-login.html',
          filename: '../page/student/stu-login.html',
          chunks: ['stu_login']
         }),
         new HtmlWebpackPlugin({
          template: './student/stu-index.html',
          filename: '../page/student/stu-index.html',
          chunks: ['stu_index','stu_inform']
         }),
         new HtmlWebpackPlugin({
          template: './student/stu-evaluation.html',
          filename: '../page/student/stu-evaluation.html',
          chunks: ['stu_evaluation','stu_inform']
         }),
         new HtmlWebpackPlugin({
          template: './student/student.html',
          filename: '../page/student/student.html',
          chunks: ['student','stu_inform']
         }),
         new HtmlWebpackPlugin({
          template: './student/stu-updatePw.html',
          filename: '../page/student/stu-updatePw.html',
          chunks: ['stu_update_pw']
         }),
         new HtmlWebpackPlugin({
          template: './student/stu-viewResult.html',
          filename: '../page/student/stu-viewResult.html',
          chunks: ['stu_view_result','stu_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-login.html',
          filename: '../page/teacher/t-login.html',
          chunks: ['t_login']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-index.html',
          filename: '../page/teacher/t-index.html',
          chunks: ['t_index','tea_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-evaluation.html',
          filename: '../page/teacher/t-evaluation.html',
          chunks: ['t_evaluation','tea_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-MyEvaluation.html',
          filename: '../page/teacher/t-MyEvaluation.html',
          chunks: ['t_my_evaluation','tea_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-evaluate.html',
          filename: '../page/teacher/t-evaluate.html',
          chunks: ['t_evaluate','tea_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-MyResult.html',
          filename: '../page/teacher/t-MyResult.html',
          chunks: ['t_my_result','tea_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-updatePw.html',
          filename: '../page/teacher/t-updatePw.html',
          chunks: ['t_update_pw']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/t-viewResult.html',
          filename: '../page/teacher/t-viewResult.html',
          chunks: ['t_view_result','tea_inform']
         }),
         new HtmlWebpackPlugin({
          template: './teacher/teacher.html',
          filename: '../page/teacher/teacher.html',
          chunks: ['teacher','tea_inform']
         })//,
         
        //  new BundleAnalyzerPlugin({
        //   //  可以是`server`，`static`或`disabled`。
        //   //  在`server`模式下，分析器将启动HTTP服务器来显示软件包报告。
        //   //  在“静态”模式下，会生成带有报告的单个HTML文件。
        //   //  在`disabled`模式下，你可以使用这个插件来将`generateStatsFile`设置为`true`来生成Webpack Stats JSON文件。
        //   analyzerMode: 'static',
        //   //  将在“服务器”模式下使用的主机启动HTTP服务器。
        //   //analyzerHost: '127.0.0.1',
        //   //  将在“服务器”模式下使用的端口启动HTTP服务器。
        //   //analyzerPort: 8888, 
        //   //  路径捆绑，将在`static`模式下生成的报告文件。
        //   //  相对于捆绑输出目录。
        //   reportFilename: 'report.html',
        //   //  模块大小默认显示在报告中。
        //   //  应该是`stat`，`parsed`或者`gzip`中的一个。
        //   //  有关更多信息，请参见“定义”一节。
        //   defaultSizes: 'parsed',
        //   //  在默认浏览器中自动打开报告
        //   openAnalyzer: true,
        //   //  如果为true，则Webpack Stats JSON文件将在bundle输出目录中生成
        //   generateStatsFile: false, 
        //   //  如果`generateStatsFile`为`true`，将会生成Webpack Stats JSON文件的名字。
        //   //  相对于捆绑输出目录。
        //   statsFilename: 'stats.json',
        //   //  stats.toJson（）方法的选项。
        //   //  例如，您可以使用`source：false`选项排除统计文件中模块的来源。
        //   //  在这里查看更多选项：https：  //github.com/webpack/webpack/blob/webpack-1/lib/Stats.js#L21
        //   statsOptions: null,
        //   logLevel: 'info' //日志级别。可以是'信息'，'警告'，'错误'或'沉默'。
        // })
         
       ],
  module: {
         rules: [
           {
             test: /\.css$/,
             use: [
               'style-loader',
               'css-loader'
             ]
            },
            {
              test: /\.(png|svg|jpg|gif)$/,
              use: [
                'file-loader'
              ]
            },
            { 
              test: /\.(jsx)$/,
              exclude: /node_modules/, 
              loader: 'babel-loader',
              options: {
                compact: true,
                presets: ['es2015', 'react']
              } 
            }
          ]
        }
};