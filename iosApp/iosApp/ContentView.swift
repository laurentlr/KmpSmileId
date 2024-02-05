import SwiftUI
import shared
import SmileID

class SmileIdInterfaceImplementation: SmileIdInterface{
    func doInit() {
        SmileID.initialize()
    }
}

struct ContentView: View {
   
    let greet = Greeting().greet()
    

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
