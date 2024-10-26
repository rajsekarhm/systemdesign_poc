
import {resolve } from 'path'
import {existsSync} from 'fs'


function getConfiguration() : any{
    const configuration_path = resolve(process.cwd(),'executor.config.js')
    const default_configuration = resolve(__dirname,'..','setup','executor.config.js')
    return existsSync(configuration_path) ? require(configuration_path) : require(default_configuration)
}


export {
    getConfiguration
}