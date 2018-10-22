/**
 *  netatmo-basestation Date: 28.06.2018
 *
 *  Copyright 2014 Brian Steere
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 * Based on Brian Steere's netatmo-basestation DTH
 */
metadata {
    definition(name: "Netatmo Basestation Noise", namespace: "cscheiene", author: "Brian Steere,cscheiene,Vanya Davidenko") {
        capability "Sound Pressure Level"
        capability "Sound Sensor"
        capability "Energy Meter"  // hack for SmartRules

        attribute "lastupdate", "string"
    }

    simulator {
        // TODO: define status and reply messages here
    }

    preferences {
        input title: "Settings", description: "To change units and time format, go to the Netatmo Connect App", displayDuringSetup: false, type: "paragraph", element: "paragraph"
        input title: "Information", description: "Your Netatmo station updates the Netatmo servers approximately every 10 minutes. The Netatmo Connect app polls these servers every 5 minutes. If the time of last update is equal to or less than 10 minutes, pressing the refresh button will have no effect", displayDuringSetup: false, type: "paragraph", element: "paragraph"
    }

    tiles(scale: 2) {
        multiAttributeTile(name: "main", type: "generic", width: 6, height: 4) {
            tileAttribute("soundPressureLevel", key: "PRIMARY_CONTROL") {
                attributeState "soundPressureLevel", label: '${currentValue} db', icon:"st.Entertainment.entertainment15", backgroundColors: [
                    [value: 35, color: "#44B621"],
                    [value: 50, color: "#ffcc00"],
                    [value: 60, color: "#e86d13"]
                ]
            }
            tileAttribute("sound", key: "SECONDARY_CONTROL") {
                attributeState "sound", label: 'Noise: ${currentValue}'
            }
        }

// SHARED CODE
        valueTile("lastupdate", "lastupdate", width: 4, height: 1, inactiveLabel: false) {
            state "default", label: "Last updated: " + '${currentValue}'
        }
        standardTile("refresh", "device.refresh", width: 1, height: 1, inactiveLabel: false, decoration: "flat") {
            state "default", action: "refresh.refresh", icon: "st.secondary.refresh"
        }

// DEVICE-SPECIFIC CODE
        valueTile("spacer", "spacer", width: 1, height: 1) {
            state "default", label:''
        }

        main(["main"])
        details(["main", "lastupdate", "spacer", "refresh"])
    }
}

// parse events into attributes
def parse(String description) {
    log.debug "Parsing '${description}'"
}

def poll() {
    log.debug "Polling"
    parent.poll()
}

def refresh() {
    log.debug "Refreshing"
    parent.poll()
}